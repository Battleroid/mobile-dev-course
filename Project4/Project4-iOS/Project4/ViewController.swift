//
//  ViewController.swift
//  Project4
//
//  Created by Casey Weed on 10/4/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func rotate(sender: UIButton) {
        self.performSegueWithIdentifier("rotateSegue", sender: nil)
    }
    
    @IBAction func scale(sender: UIButton) {
        self.performSegueWithIdentifier("scaleSegue", sender: nil)
    }

}

