//
//  RC4.swift
//  Project2
//
//  Created by Casey Weed on 9/7/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import Foundation

class RC4 {
    var s:[UInt8]
    var I:UInt8 = 0
    var J:UInt8 = 0
    
    init(_ key: [UInt8]) {
        // create empty array of byte values
        s = [UInt8](count: 256, repeatedValue: UInt8(0))
        
        // init array with values
        for i in 0..<256 {
            s[i] = UInt8(i)
        }
        var j:UInt8 = 0
        for i in 0..<256 {
            let K:UInt8 = key[i % key.count]
            let S:UInt8 = s[i]
            j = j &+ S &+ K
            swapIdx(i, b: Int(j))
        }
    }
    
    func next() -> UInt8 {
        I = I &+ 1
        J = J &+ s[Int(I)]
        swapIdx(Int(I), b: Int(J))
        return s[Int(s[Int(I)] &+ s[Int(J)]) & 0xFF]
    }
    
    func swapIdx(a: Int, b: Int) {
        let t1:UInt8 = s[a]
        let t2:UInt8 = s[b]
        s[a] = t2
        s[b] = t1
    }
}