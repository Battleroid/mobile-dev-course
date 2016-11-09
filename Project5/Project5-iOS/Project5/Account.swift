//
//  Account.swift
//  Project5
//
//  Created by Casey Weed on 10/12/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import Foundation

class Account {
    var username = "user"
    var password = "pass"
    var service = "example.com"
    
    init(_ username: String, _ password: String, _ service: String) {
        self.username = username
        self.password = password
        self.service = service
    }
}