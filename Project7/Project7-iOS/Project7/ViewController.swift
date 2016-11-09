//
//  ViewController.swift
//  Project7
//
//  Created by Casey Weed on 11/8/16.
//  Copyright © 2016 Casey Weed. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var cityTxt: UITextField!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var humidityLabel: UILabel!
    @IBOutlet weak var windLabel: UILabel!
    @IBOutlet weak var temperatureLabel: UILabel!
    
    let api_key = "0a1a045b3802454c4d7f8feb00ba74f7"
    let base_url = "http://api.openweathermap.org/data/2.5/weather?q=<city>&APPID=<api>"

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func getWeather(sender: AnyObject) {
        print("Using \(cityTxt.text!)")
        
        dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0)) {
            // build request url
            var request_url = self.base_url
            request_url = request_url.stringByReplacingOccurrencesOfString("<city>", withString: self.cityTxt.text!)
            request_url = request_url.stringByReplacingOccurrencesOfString("<api>", withString: self.api_key)
            let request_ns_url:NSURL = NSURL(string: request_url)!
            let request:NSMutableURLRequest = NSMutableURLRequest(URL: request_ns_url)
            let session:NSURLSession = NSURLSession.sharedSession()
            
            let task = session.dataTaskWithRequest(request, completionHandler: {
                data, response, err -> Void in
                
                do {
                    let json = try! NSJSONSerialization.JSONObjectWithData(data!, options: NSJSONReadingOptions.MutableContainers) as! NSDictionary
                    print(json["cod"])
                    
                    // get description
                    if let weather = json["weather"] as? [AnyObject] {
                        if let info = weather[0] as? NSDictionary {
                            var desc = info["description"] as! String
                            desc = String(desc.characters.prefix(1)).uppercaseString + String(desc.characters.dropFirst())
                            dispatch_async(dispatch_get_main_queue()) {
                                self.descriptionLabel.text = desc
                            }
                        }
                    }
                    
                    // get humidity & temperature
                    if let main = json["main"] as? NSDictionary {
                        dispatch_async(dispatch_get_main_queue()) {
                            self.humidityLabel.text = String(main["humidity"] as! Int) + "%"
                            self.temperatureLabel.text = String(main["temp"] as! Double)
                        }
                    }
                    
                    // get wind speed
                    if let wind = json["wind"] as? NSDictionary {
                        dispatch_async(dispatch_get_main_queue()) {
                            self.windLabel.text = String(wind["speed"] as! Double)
                        }
                    }
                } catch {
                    print("Error parsing JSON")
                }
            })
            
            task.resume()
        }
    }
    
}

	