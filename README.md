# Bike Tracker Android Application
## UCR EE Senior Design Project Winter 2016

Group members: Yang Deng, Simin Zhang

This is code for the Android application that I created for my group's project: The Bike Electronic System.

## Executive Summary of our project

The Bike Electronic System is a system designed to control various accessories on your bike. 

In today's modern age, many parts of our daily life are continuously being integrated with technology. 

The reason we chose to make an electronic system for the bike is that there is currently little technology integrating bike accessories into one system. 

You can find bike Global Positioning Systems (GPS) and bike lighting solutions sold separately at major retailers, but you will have trouble finding a product that does both. 

Our goal is to make it easier for consumers to buy everything they need by including major bike accessories into one product while making it easy for the consumer to control everything. 

The Bike Electronic System consists of two main components: the Bike Module, which contains all of the hardware of the system, and the application, which contains the software designed to control the Bike Module.

The bike module (hardware) contains all of the circuitry that makes this system work. 

At the center of the system is an Arduino Uno, which controls all of the features. 

The features of the system are: an Adafruit FONA for GPS tracking, Liquid-Crystal Display to show the rider information, light-emitting diodes (LEDs) for bike visibility, a buzzer for bike aural location, and a battery to power the system on-the-go.

The software portion of the system is an Android Application (app) that controls the different parts of the hardware system. 

It can request the GPS coordinates of the bike, turn the LEDs on and off, check battery voltage, and check bike acceleration. 

The app is able to display the location of the bike on Google Maps and even create a path that the bike rode on using saved GPS locations.

Our goal is to have all parts of the project to work together seamlessly and without any problems. 

Testing the product resulted in most of the functions of the Bike Electronic System working together without problems and communication between the application and the bike module to be working correctly.

The system works while on the bike is able to record the location accurately even while moving. With that, the applications was able to create an accurate path detailing the route of the bike.
