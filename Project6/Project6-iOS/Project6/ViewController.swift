//
//  ViewController.swift
//  Project6
//
//  Created by Casey Weed on 10/25/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var numInput: UITextField!
    @IBOutlet weak var numTV: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func start(sender: AnyObject) {
        let limit = Int(numInput.text!)
        if limit <= 2 {
            numTV.text = "Limit too low!"
            return
        }
        
        startTwinPrimeSearch(limit!)
    }
    
    
    func startTwinPrimeSearch(n: Int) {
        numTV.text = "Twins:"
        dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0)) {
            var i = 1
            while i <= (n - 2) {
                if self.isPrime(i) && self.isPrime(i + 2) {
                    let pair = " [\(i), \(i + 2)]"
                    dispatch_async(dispatch_get_main_queue()) {
                        self.numTV.text.appendContentsOf(pair)
                    }
                }
                
                i += 1
            }
        }
    }
    
    func isPrime(n: Int) -> Bool {
        var count = 0
        for i in 1...n {
            if n % i == 0 {
                count += 1
            }
        }
        return count == 2
    }
    
}

