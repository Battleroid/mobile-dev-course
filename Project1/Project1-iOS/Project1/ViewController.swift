//
//  ViewController.swift
//  Project1
//
//  Created by Casey Weed on 8/28/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var numfield: UITextField!
    var seq:Int = 2

    override func viewDidLoad() {
        super.viewDidLoad()
        numfield.text = "1"
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    func fib(n: Int) -> Int {
        if n < 2 {
            return n
        } else {
            return fib(n - 1) + fib(n - 2)
        }
    }
    
    @IBAction func inc(sender: UIButton) {
        seq += 1
        numfield.text = String(fib(seq))
    }
    
    @IBAction func reset(sender: UIButton) {
        seq = 2
        numfield.text = "1"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

