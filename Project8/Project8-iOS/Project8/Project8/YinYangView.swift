//
//  YinYangView.swift
//  Project8
//
//  Created by Casey Weed on 11/27/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import UIKit

class YinYangView: UIView {
    
    var x:CGFloat = 0
    var y:CGFloat = 0
    let r:CGFloat = 50
    
    override func drawRect(rect: CGRect) {
        // Use view's frame dimensions to determine center
        x = self.frame.width / 2
        y = self.frame.height / 2
        
        // base white circle
        UIColor.whiteColor().setFill()
        UIColor.blackColor().setStroke()
        let baseCircle = UIBezierPath(ovalInRect: CGRect(x: self.x - self.r / 2, y: self.y - self.r / 2, width: self.r, height: self.r))
        baseCircle.lineWidth = 1.0
        baseCircle.fill()
        baseCircle.stroke()
        
        // black semi circle
        UIColor.blackColor().setFill()
        let center = CGPoint(x: self.x, y: self.y)
        let sweep = 0.5
        let start = CGFloat(3 * M_PI_2)
        let end = start + CGFloat(2 * M_PI * sweep)
        let blackSemiCircle = UIBezierPath(arcCenter: center, radius: self.r / 2, startAngle: start, endAngle: end, clockwise: true)
        blackSemiCircle.fill()
        
        // top white circle
        var size = self.r / 2
        UIColor.whiteColor().setFill()
        let topWhiteCircle = UIBezierPath(ovalInRect: CGRect(x: self.x - size / 2, y: self.y - size + 1, width: size, height: size))
        topWhiteCircle.fill()
        
        // bottom black circle
        UIColor.blackColor().setFill()
        let bottomBlackCircle = UIBezierPath(ovalInRect: CGRect(x: self.x - size / 2, y: self.y, width: size, height: size))
        bottomBlackCircle.fill()
        
        // top black dot
        size = self.r / 6
        UIColor.blackColor().setFill()
        let topBlackDot = UIBezierPath(ovalInRect: CGRect(x: self.x - size / 2, y: self.y - (size * 2) + 1, width: size, height: size))
        topBlackDot.fill()
        
        // bottom white dot
        UIColor.whiteColor().setFill()
        let bottomWhiteDot = UIBezierPath(ovalInRect: CGRect(x: self.x - size / 2, y: self.y + size, width: size, height: size))
        bottomWhiteDot.fill()
    }
    
// Was not sure if you wanted drag and drop or not. This would make only a single view
// move to the touch position which is not what I believe the assignment was. So I used
// pan gesture recognizers to allow you to move either symbol.
    
// The two methods below would allow you to drag the symbol within the view's frame though,
// provided you remove centering based off the frame under drawRect().

//    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
//        if let touch = touches.first {
//            let p = touch.locationInView(self)
//            self.x = p.x
//            self.y = p.y
//            self.setNeedsDisplay()
//        }
//    }
//
// Need began and moved or else it'll only move when you begin dragging or only move to the
// initial location you touch.
//
//    override func touchesMoved(touches: Set<UITouch>, withEvent event: UIEvent?) {
//        if let touch = touches.first {
//            let p = touch.locationInView(self)
//            self.x = p.x
//            self.y = p.y
//            self.setNeedsDisplay()
//        }
//    }

}
