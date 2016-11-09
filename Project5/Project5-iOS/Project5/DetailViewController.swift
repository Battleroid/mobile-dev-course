//
//  DetailViewController.swift
//  Project5
//
//  Created by Casey Weed on 10/12/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController {
    
    @IBOutlet weak var serviceTxt: UITextField!
    @IBOutlet weak var passwordTxt: UITextField!
    @IBOutlet weak var usernameTxt: UITextField!
    @IBOutlet weak var detailDescriptionLabel: UILabel!

    var detailItem: Account? {
        didSet {
            // Update the view.
            self.configureView()
        }
    }
	
    func configureView() {
        // Update the user interface for the detail item.
        if let detail = self.detailItem {
            if let label = self.detailDescriptionLabel {
                label.text = detail.service
                self.title = detail.service
                self.usernameTxt.text = detail.username
                self.passwordTxt.text = detail.password
                self.serviceTxt.text = detail.service
                
                self.title = detail.service
            }
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.configureView()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func save(sender: AnyObject) {
        detailItem?.username = usernameTxt.text!
        detailItem?.password = passwordTxt.text!
        detailItem?.service = serviceTxt.text!
    }

}

