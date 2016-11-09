//
//  ViewController.swift
//  Project2
//
//  Created by Casey Weed on 9/7/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var r = RC4([1, 3, 5])
    @IBOutlet weak var randValue: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func generate(sender: AnyObject) {
        randValue.text = String(r.next())
    }
}

