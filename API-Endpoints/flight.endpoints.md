## **API Endpoints:**

> ### FlightSearch:

1.  For all flight:
    URL- [GET] http://localhost:9999/flight/

    1. **Request-** - Url -http://localhost:9999/flight/
       **Response-**
       [
       {
       "flightId": 1,
       "serviceProviderName": "IndiGo",
       "flightName": "IndiGo_123",
       "departureLocation": "Lucknow",
       "departureDate": "2023-03-23",
       "departureTime": "06:35:00",
       "arrivalLocation": "New Delhi",
       "arrivalDate": "2023-03-23",
       "arrivalTime": "13:20:00",
       "flightClass": "economy",
       "availability": 3,
       "price": 2506
       },
       {
       "flightId": 2,
       "serviceProviderName": "Air India",
       "flightName": "AirIndia_423",
       "departureLocation": "Prayagraj",
       "departureDate": "2023-03-25",
       "departureTime": "08:35:00",
       "arrivalLocation": "New Delhi",
       "arrivalDate": "2023-03-25",
       "arrivalTime": "13:20:00",
       "flightClass": "business",
       "availability": 3,
       "price": 5500
       },
       {
       "flightId": 3,
       "serviceProviderName": "IndiGo",
       "flightName": "IndiGo_333",
       "departureLocation": "Prayagraj",
       "departureDate": "2023-03-25",
       "departureTime": "08:35:00",
       "arrivalLocation": "New Delhi",
       "arrivalDate": "2023-03-25",
       "arrivalTime": "13:20:00",
       "flightClass": "business",
       "availability": 6,
       "price": 2506
       }
       ]

2.  For flight with id:
    URL- [GET] http://localhost:9999/flight/{id}

    1. **Request-**
       - url:http://localhost:9999/flight/1
         **Response-**
         {
         "flightId": 1,
         "serviceProviderName": "IndiGo",
         "flightName": "IndiGo_123",
         "departureLocation": "Lucknow",
         "departureDate": "2023-03-23",
         "departureTime": "06:35:00",
         "arrivalLocation": "New Delhi",
         "arrivalDate": "2023-03-23",
         "arrivalTime": "13:20:00",
         "flightClass": "economy",
         "availability": 3,
         "price": 2506
         }

3.  For flight search with {Departure Location, Arrival Location, Flight Class, Date}:
    URL- [GET] http://localhost:9999/flight/findWith?departureLocation={value}&arrivalLocation={value}&flightClass={value}&date={value}

    1. **Request-**

       - url- http://localhost:9999/flight/findWith?departureLocation=Lucknow&arrivalLocation=New Delhi&flightClass=economy&date=2023-03-23

       **Response-**[
       {
       "flightId": 1,
       "serviceProviderName": "IndiGo",
       "flightName": "IndiGo_123",
       "departureLocation": "Lucknow",
       "departureDate": "2023-03-23",
       "departureTime": "06:35:00",
       "arrivalLocation": "New Delhi",
       "arrivalDate": "2023-03-23",
       "arrivalTime": "13:20:00",
       "flightClass": "economy",
       "availability": 3,
       "price": 2506
       }
       ]

4.  For adding flight:
    URL- [POST] http://localhost:9999/flight/
    Response Body- flight object

    Example:

    1. **Request-**{
       "serviceProviderName": "IndiGo",
       "flightName": "IndiGo_123",
       "departureLocation": "Lucknow",
       "departureDate": "2023-03-23",
       "departureTime": "06:35",
       "arrivalLocation":"New Delhi",
       "arrivalDate":"2023-03-23",
       "arrivalTime":"13:20",
       "flightClass":"economy",
       "availability": 3,
       "price": 2506
       }
       **Response-**
       {
       "flightId": 1,
       "serviceProviderName": "IndiGo",
       "flightName": "IndiGo_123",
       "departureLocation": "Lucknow",
       "departureDate": "2023-03-23",
       "departureTime": "06:35:00",
       "arrivalLocation": "New Delhi",
       "arrivalDate": "2023-03-23",
       "arrivalTime": "13:20:00",
       "flightClass": "economy",
       "availability": 3,
       "price": 2506
       }
    2. **Request-**
       {
       "serviceProviderName": "IndiGo",
       "flightName": "IndiGo_423",
       "departureLocation": "Prayagraj",
       "departureDate": "2023-03-25",
       "departureTime": "08:35",
       "arrivalLocation":"New Delhi",
       "arrivalDate":"2023-03-25",
       "arrivalTime":"13:20",
       "flightClass":"business",
       "availability": 3,
       "price": 2506
       }
       **Response-**
       {
       "flightId": 2,
       "serviceProviderName": "IndiGo",
       "flightName": "IndiGo_423",
       "departureLocation": "Prayagraj",
       "departureDate": "2023-03-25",
       "departureTime": "08:35:00",
       "arrivalLocation": "New Delhi",
       "arrivalDate": "2023-03-25",
       "arrivalTime": "13:20:00",
       "flightClass": "business",
       "availability": 3,
       "price": 2506
       }

5.  For updating flight:
    URL- [PUT] http://localhost:9999/flight/{id}
    Response Body- flight object

    Example- 1.**Request-**

    - Url-http://localhost:9999/flight/2
    - {
      "flightId": 2,
      "serviceProviderName": "Air India",
      "flightName": "AirIndia_423",
      "departureLocation": "Prayagraj",
      "departureDate": "2023-03-25",
      "departureTime": "08:35",
      "arrivalLocation":"New Delhi",
      "arrivalDate":"2023-03-25",
      "arrivalTime":"13:20",
      "flightClass":"business",
      "availability": 3,
      "price": 5500
      }
      **Response-**
      {
      "flightId": 2,
      "serviceProviderName": "Air India",
      "flightName": "AirIndia_423",
      "departureLocation": "Prayagraj",
      "departureDate": "2023-03-25",
      "departureTime": "08:35:00",
      "arrivalLocation": "New Delhi",
      "arrivalDate": "2023-03-25",
      "arrivalTime": "13:20:00",
      "flightClass": "business",
      "availability": 3,
      "price": 5500
      }

6.  For deleting flight:

    - URL: [DELETE] http://localhost:9999/flight/{id}
    - Example:

    1. **Request-**
       url: http://localhost:9999/flight/3
       **Response-**
       HttpStatus- 200 Ok

7.  For Adding Service Provider:

    - URL [POST] http://localhost:9999/flight/serviceProvider
    - Request Body- Service Provider
    - Example: 1. **Request-**
      {
      "serviceProviderName": "Air India",
      "serviceProviderEmail": "airindia.com",
      "serviceProviderNumber": "123456789"
      }
      **Response-**
      {
      "serviceProviderId": 1,
      "serviceProviderName": "Air India",
      "serviceProviderEmail": "airindia.com",
      "serviceProviderNumber": 123456789
      }

8.  For Finding Service Provider Details:

    - URL [Get] http://localhost:9999/flight/serviceProvider/{service-provider-name}

    - Example:
      1. **Request-**
         -url: http://localhost:9999/flight/serviceProvider/IndiGo
         **Response-**
         {
         "serviceProviderId": 2,
         "serviceProviderName": "IndiGo",
         "serviceProviderEmail": "indigo.com",
         "serviceProviderNumber": 123456789
         }

9.  For booking one way flight:

    - URL [POST] http://localhost:9999/flight/bookingOneWayFlight
    - Request Body- BookingForOneWayFlight {
      "customerEmail": "",
      "order":{},
      "payment":{},
      "flight": {
      "flightId": ,
      "flightName": "",
      "departureLocation": "",
      "departureDate": "",
      "arrivalLocation": "",
      "arrivalDate": "",
      "flightClass": ""
      }
      "numberOfSeatBook":1
      }
    - Example:

    1. **Request-**
       {
       "customerEmail": "kritikasingh6421@gmail.com",
       "order":{},
       "payment":{},
       "flight":{
       "flightId": 2,
       "flightName": "AirIndia_423",
       "departureLocation": "Prayagraj",
       "departureDate": "2023-03-25",
       "arrivalLocation": "New Delhi",
       "arrivalDate": "2023-03-25",
       "flightClass": "business"
       }
       "numberOfSeatBook":1
       }
       **Response-**
       {
       "customerEmail": "kritikasingh6421@gmail.com",
       "order": {
       "orderId": 1,
       "productId": 2,
       "serviceProviderName": "Air India",
       "customerEmail": "kritikasingh6421@gmail.com",
       "transactionId": "6539d63e-e65b-46c0-a31d-59761961c10e",
       "totalAmount": 5500.0,
       "orderDate": "2023-03-28",
       "orderTime": "16:08:43.6651361",
       "orderStatus": "order successful",
       "tripType": "ONE WAY TRIP",
       "noOfSeatBook": 1
       },
       "payment": {
       "paymentId": 3,
       "transactionId": "6539d63e-e65b-46c0-a31d-59761961c10e",
       "orderId": 1,
       "customerEmail": "kritikasingh6421@gmail.com",
       "totalAmount": 5500.0,
       "paymentDate": "2023-03-28",
       "paymentTime": "16:08:43.7203175",
       "paymentStatus": "Successful"
       },
       "flight": {
       "flightId": 2,
       "serviceProviderName": "Air India",
       "flightName": "AirIndia_423",
       "departureLocation": "Prayagraj",
       "departureDate": "2023-03-25",
       "departureTime": "08:35:00",
       "arrivalLocation": "New Delhi",
       "arrivalDate": "2023-03-25",
       "arrivalTime": "13:20:00",
       "flightClass": "business",
       "availability": 2,
       "price": 5500.0
       },
       "numberOfSeatBook": 1

    }

10. **Request-** when user sepecification did not match
    {
    "customerEmail": "kritikasingh6421@gmail.com",
    "order":{},
    "payment":{},
    "flight":{
    "flightId": 2,
    "flightName": "AirIndia_423",
    "departureLocation": "Prayagraj",
    "departureDate": "2023-03-25",
    "arrivalLocation": "New Delhi",
    "arrivalDate": "2023-03-25",
    "flightClass": "economy"
    },
    "numberOfSeatBook":1

    }

    **Response-**
    Bad Request Http status- 400

11. For cancel one way flight:

    - URL [POST] http://localhost:9999/flight/cancelOneWayFlight
    - Request Body- Order
    - Example:

    1. **Request-**
       {
       "orderId": 1,
       "productId": 2,
       "serviceProviderName": "Air India",
       "customerEmail": "kritikasingh6421@gmail.com",
       "transactionId": "6539d63e-e65b-46c0-a31d-59761961c10e",
       "totalAmount": 5500.0,
       "orderDate": "2023-03-28",
       "orderTime": "16:08:43.6651361",
       "orderStatus": "order successful",
       "tripType": "ONE WAY TRIP",
       "noOfSeatBook": 1
       }
       **Response-**
       {
       "orderId": 1,
       "productId": 2,
       "serviceProviderName": "Air India",
       "customerEmail": "kritikasingh6421@gmail.com",
       "transactionId": "6539d63e-e65b-46c0-a31d-59761961c10e",
       "totalAmount": 5500.0,
       "orderDate": "2023-03-28",
       "orderTime": "16:08:43.6651361",
       "orderStatus": "order cancel",
       "tripType": "ONE WAY TRIP",
       "noOfSeatBook": 1

    }

12. For booking two way flight:

- URL [POST] http://localhost:9999/flight/bookingTwoWayFlight
- Request Body- BookingTwoWayFlight

{
"order": {},
"payment" :{},
"flight1":{},
"flight2":{},
"noOfSeatBook": ,
"customerEmail":""
}

- Example: 1. **Request-**
  {
  "order": {},
  "payment" :{},
  "flight1":{
  "flightId": 2,
  "flightName": "AirIndia_423",
  "departureLocation": "Prayagraj",
  "departureDate": "2023-03-25",
  "arrivalLocation": "New Delhi",
  "arrivalDate": "2023-03-25",
  "flightClass": "business"
  },
  "flight2":{
  "flightId": 4,
  "flightName": "IndiGo_333",
  "departureLocation": "New Delhi",
  "departureDate": "2023-03-26",
  "arrivalLocation": "Prayagraj",
  "arrivalDate": "2023-03-27",
  "flightClass": "business"
  },
  "noOfSeatBook": 1,
  "customerEmail":"kritikasingh6421@gmail.com"
  }
  **Response-**

  {
  "order": {
  "orderId": 4,
  "product1Id": 2,
  "product2Id": 4,
  "serviceProviderName1": "Air India",
  "serviceProviderName2": "IndiGo",
  "customerEmail": "kritikasingh6421@gmail.com",
  "transactionId": "20de33b3-c79e-4a6f-b1df-e420c105441c",
  "totalAmount": 8006.0,
  "orderDate": "2023-03-28",
  "orderTime": "16:38:14.4986568",
  "orderStatus": "order successful",
  "tripType": "TWO WAY TRIP",
  "noOfSeatBook": 1
  },
  "payment": {
  "paymentId": 4,
  "transactionId": "20de33b3-c79e-4a6f-b1df-e420c105441c",
  "orderId": 4,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 8006.0,
  "paymentDate": "2023-03-28",
  "paymentTime": "16:38:14.6683601",
  "paymentStatus": "Successful"
  },
  "flight1": {
  "flightId": 2,
  "serviceProviderName": "Air India",
  "flightName": "AirIndia_423",
  "departureLocation": "Prayagraj",
  "departureDate": "2023-03-25",
  "departureTime": "08:35:00",
  "arrivalLocation": "New Delhi",
  "arrivalDate": "2023-03-25",
  "arrivalTime": "13:20:00",
  "flightClass": "business",
  "availability": 2,
  "price": 5500.0
  },
  "flight2": {
  "flightId": 4,
  "serviceProviderName": "IndiGo",
  "flightName": "IndiGo_333",
  "departureLocation": "New Delhi",
  "departureDate": "2023-03-26",
  "departureTime": "08:35:00",
  "arrivalLocation": "Prayagraj",
  "arrivalDate": "2023-03-27",
  "arrivalTime": "13:20:00",
  "flightClass": "business",
  "availability": 5,
  "price": 2506.0
  },
  "noOfSeatBook": 1,
  "customerEmail": "kritikasingh6421@gmail.com"
  }

13. For cancel one way flight:

- URL [POST] http://localhost:9999/flight/cancelTwoWayFlight
- Request Body- Order
- Example: 1. **Request-**
  {
  "orderId": 4,
  "product1Id": 2,
  "product2Id": 4,
  "serviceProviderName1": "Air India",
  "serviceProviderName2": "IndiGo",
  "customerEmail": "kritikasingh6421@gmail.com",
  "transactionId": "20de33b3-c79e-4a6f-b1df-e420c105441c",
  "totalAmount": 8006.0,
  "orderDate": "2023-03-28",
  "orderTime": "16:38:14.4986568",
  "orderStatus": "order successful",
  "tripType": "TWO WAY TRIP",
  "noOfSeatBook": 1
  }
  **Response-**
  {
  "orderId": 4,
  "product1Id": 2,
  "product2Id": 4,
  "serviceProviderName1": "Air India",
  "serviceProviderName2": "IndiGo",
  "customerEmail": "kritikasingh6421@gmail.com",
  "transactionId": "20de33b3-c79e-4a6f-b1df-e420c105441c",
  "totalAmount": 8006.0,
  "orderDate": "2023-03-28",
  "orderTime": "16:38:14.4986568",
  "orderStatus": "order cancel",
  "tripType": "TWO WAY TRIP",
  "noOfSeatBook": 1
  }

14. For All orders of one way trip by user:

- URL [GET] http://localhost:9999/flight/ordersForOneWayTrip/{email}
- Example:

1.  **Request-**
    url- http://localhost:9999/flight/ordersForOneWayTrip/kritikasingh6421@gmail.com
    **Response-**
    [
    {
    "orderId": 1,
    "productId": 2,
    "serviceProviderName": "Air India",
    "customerEmail": "kritikasingh6421@gmail.com",
    "transactionId": "6539d63e-e65b-46c0-a31d-59761961c10e",
    "totalAmount": 5500.0,
    "orderDate": "2023-03-28",
    "orderTime": "16:08:43",
    "orderStatus": "order cancel",
    "tripType": "ONE WAY TRIP",
    "noOfSeatBook": 1
    }
    ]

2.  For All orders of return trip by user:

- URL [GET] http://localhost:9999/flight/ordersForTwoWayTrip/{email}
  - Example:
  1.  **Request-**
      url: http://localhost:9999/flight/ordersForTwoWayTrip/kritikasingh6421@gmail.com
      **Response-**
      [
      {
      "orderId": 4,
      "product1Id": 2,
      "product2Id": 4,
      "serviceProviderName1": "Air India",
      "serviceProviderName2": "IndiGo",
      "customerEmail": "kritikasingh6421@gmail.com",
      "transactionId": "20de33b3-c79e-4a6f-b1df-e420c105441c",
      "totalAmount": 8006.0,
      "orderDate": "2023-03-28",
      "orderTime": "16:38:14",
      "orderStatus": "order cancel",
      "tripType": "TWO WAY TRIP",
      "noOfSeatBook": 1
      }
      ]
