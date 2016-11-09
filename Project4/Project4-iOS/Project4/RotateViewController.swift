//
//  RotateViewController.swift
//  Project4
//
//  Created by Casey Weed on 10/4/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import UIKit

class RotateViewController: UIViewController {
    
    @IBOutlet weak var rotateSwitch: UISwitch!
    @IBOutlet weak var rotateImage: UIImageView!

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        rotateSwitch.addTarget(self, action: Selector("changed:"), forControlEvents: UIControlEvents.ValueChanged)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func changed(state: UISwitch) {
        if state.on {
            let anim = CABasicAnimation()
            anim.fromValue = 0
            anim.toValue = CGFloat(M_PI * 2.0)
            anim.duration = 1.0
            anim.repeatCount = Float.infinity
            anim.removedOnCompletion = false
            anim.fillMode = kCAFillModeForwards
            anim.timingFunction = CAMediaTimingFunction(name: kCAMediaTimingFunctionLinear)
            rotateImage.layer.addAnimation(anim, forKey: "transform.rotation.z")
        } else {
            rotateImage.layer.removeAllAnimations()
        }
    }

}
