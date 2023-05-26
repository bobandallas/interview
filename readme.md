## Reward Build with JPA

### Get All
#### Request Url : /reward
#### Request method : GET
#### Request Body : null
#### Response Body : 
```
[
    {
        "id": 1,
        "name": "John",
        "totalPoints": 590,
        "monthlyPoints": [
            590,
            0,
            0
        ]
    },
    {
        "id": 2,
        "name": "Bob",
        "totalPoints": 1850,
        "monthlyPoints": [
            1850,
            0,
            0
        ]
    }
]
```
##### id means Customer Id
##### name is Customer Name
##### totalPoints is 3 months total reward points
##### monthlyPoints array shows each month detail reward points sort by month
