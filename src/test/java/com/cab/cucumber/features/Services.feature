@Services

Feature: cab services
Scenario Outline: Verify Mini Car Service Link 

Given Navigate to Services Page
When I click the "<Type>" cab service link
Then verify the car image and details for the "<Type>" which contains the "<Details>"

Examples:
|Type| Details| 

|Mini| Mini Cars|
|Micro| Micro Cars|
|SUV| Suv Cars|
|Sedan| Sedan Cars|