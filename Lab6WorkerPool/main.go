package main

import (
    "fmt"
    "io"
    "net/http"
    "sync"
)

// downloadWorker is a worker in the pool
// it reads URLs from urlChan, downloads them, and prints info

func downloadWorker(id int, urlChan <-chan string, wg *sync.WaitGroup) {
    defer wg.Done() // runs at the end of the function to tell the WaitGroup this worker is finished

    for url := range urlChan { // loop receives URLs from the channel until it is closed
        fmt.Printf("[Worker %d] starting %s\n", id, url)

        resp, err := http.Get(url) // sends HTTP GET request to URL
        if err != nil { // if there's an error print this message continue to next URL
            fmt.Printf("[Worker %d] %s -> ERROR: %v\n", id, url, err)
            continue
        }

        size, err := io.Copy(io.Discard, resp.Body) // counts bytes
        resp.Body.Close()
        if err != nil { // if there's an error print this message continue to next URL
            fmt.Printf("[Worker %d] %s -> ERROR reading body: %v\n", id, url, err)
            continue
        }
		
		// displays the output, including URL, status code, and size of downloaded content for each item
        fmt.Printf("[Worker %d] %s -> Status: %d | Size: %d bytes\n",  
            id, url, resp.StatusCode, size)
    }
}

func main() {
    urls := []string{  //list of URLs to download
        "https://www.google.com",
        "https://go.dev",
        "https://uottawa.ca",
        "https://wikipedia.org",
		"https://leetcode.com/",
		"https://www.python.org/",
    }

    numWorkers := 3  // 3 URLs can be processed at the same time
    urlChan := make(chan string)// creates channel of strings
    var wg sync.WaitGroup // declares WaitGroup named wg

    // start N worker goroutines
    for i := 1; i <= numWorkers; i++ {
        wg.Add(1)
        go downloadWorker(i, urlChan, &wg)
    }

    // send tasks into jobs channel
    go func() {
        for _, u := range urls { // loops over all URLs in the slice
            urlChan <- u 
        }
        close(urlChan) // close channel
    }()

    // wait for all goroutines to finish
    wg.Wait()
    fmt.Println("All downloads finished.")
}

// Lab 6 done by Mihai Jalbu, Adam Mourad and Wafi Choudhury with help from online resources such as the tutorials that were linked in the lab description and ChatGPT to help understand concepts.