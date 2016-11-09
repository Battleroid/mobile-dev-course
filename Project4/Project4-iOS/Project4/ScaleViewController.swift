//
//  ScaleViewController.swift
//  Project4
//
//  Created by Casey Weed on 10/4/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import UIKit

class ScaleViewController: UIViewController {

    @IBOutlet weak var scaleImage: UIImageView!
    @IBOutlet weak var scaleSwitch: UISwitch!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        scaleSwitch.addTarget(self, action: Selector("changed:"), forControlEvents: UIControlEvents.ValueChanged)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func changed(state: UISwitch) {
        if state.on {
            let anim = CABasicAnimation()
            anim.fromValue = 1.0
            anim.toValue = 1.25
            anim.duration = 1.0
            anim.removedOnCompletion = false
            anim.timingFunction = CAMediaTimingFunction(name: kCAMediaTimingFunctionLinear)
            anim.fillMode = kCAFillModeBoth
            anim.autoreverses = true
            anim.repeatCount = Float.infinity
            scaleImage.layer.addAnimation(anim, forKey: "transform.scale")
        } else {
            scaleImage.layer.removeAllAnimations()
        }
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
