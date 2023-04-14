## **API Endpoints:**

### HotelSearch:

1. For all Hotels:
   -URL [GET] http://localhost:9999/hotel/
   -Example:
   1. **Request-**
      url : http://localhost:9999/hotel
      **Response-**
      [
      {
      "hotelId": 1,
      "serviceProviderName": "Lemon Tree Hotels",
      "hotelName": "Lemon Tree Premier",
      "city": "Gurugram",
      "numberOfRoomsAvailable": 20,
      "price": 2500.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      },
      {
      "hotelId": 2,
      "serviceProviderName": "Paradise Hotels",
      "hotelName": "Paradise",
      "city": "New Delhi",
      "numberOfRoomsAvailable": 2,
      "price": 5600.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      },
      {
      "hotelId": 4,
      "serviceProviderName": "Paradise Hotels",
      "hotelName": "Paradise 1",
      "city": "New Delhi",
      "numberOfRoomsAvailable": 2,
      "price": 5600.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-23",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      }
      ]
2. For Hotel Search with id:
   -URL [GET] http://localhost:9999/hotel/{id}
   -Example:

   1. **Request-**
      url : http://localhost:9999/hotel/1
      **Response-**
      {
      "hotelId": 1,
      "serviceProviderName": "Lemon Tree Hotels",
      "hotelName": "Lemon Tree Premier",
      "city": "Gurugram",
      "numberOfRoomsAvailable": 20,
      "price": 2500.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      }

3. For Hotel Search with {name, city, check in date, check out date}:

   - URL: [GET] http://localhost:9999/hotel/findWith?name={value}&city={value}&checkInDate={value}&checkOutDate={value}
   - Example:

   1. **Request-**
      url: http://localhost:9999/hotel/findWith?name=Lemon Tree Premier&city=gurugram&checkInDate=2023-03-23&checkOutDate=2023-03-24
      **Response-**
      [
      {
      "hotelId": 1,
      "serviceProviderName": "Lemon Tree Hotels",
      "hotelName": "Lemon Tree Premier",
      "city": "Gurugram",
      "numberOfRoomsAvailable": 20,
      "price": 2500.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      }
      ]

4. For wishlised Hotels:

   - URL [GET] http://localhost:9999/hotel/wishlist
   - Example:

   1. **Request-**
      url: http://localhost:9999/hotel/wishlist
      **Response-**
      [
      {
      "hotelId": 2,
      "serviceProviderName": "Paradise Hotels",
      "hotelName": "Paradise",
      "city": "New Delhi",
      "numberOfRoomsAvailable": 2,
      "price": 5600.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": true,
      "booked": false
      }
      ]

5. For adding Hotel to wishlist:

   - URL [PUT] http://localhost:9999/hotel/addToWishList/{id}
   - Example:

   1. **Request-**
      url: http://localhost:9999/hotel/addToWishList/2
      **Response-**
      {
      "hotelId": 2,
      "serviceProviderName": "Paradise Hotels",
      "hotelName": "Paradise",
      "city": "New Delhi",
      "numberOfRoomsAvailable": 2,
      "price": 5600.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": true,
      "booked": false
      }

6. For adding Hotel:  
    -URL [POST] http://localhost:9999/hotel/
   -Request Body- hotel object
   -Example:

   1. **Request-**
      Request Body:
      {
      "serviceProviderName": "Lemon Tree Hotels",
      "hotelName": "Lemon Tree Premier",
      "city": "Gurugram",
      "numberOfRoomsAvailable": 20,
      "price": 2500.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      }
      **Response-**
      {
      "hotelId": 1,
      "serviceProviderName": "Lemon Tree Hotels",
      "hotelName": "Lemon Tree Premier",
      "city": "Gurugram",
      "numberOfRoomsAvailable": 20,
      "price": 2500.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      }
   2. **Request-**
      Request Body:
      {
      "serviceProviderName": "Paradise Hotels",
      "hotelName": "Paradise",
      "city": "New Delhi",
      "numberOfRoomsAvailable": 2,
      "price": 5600.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      }
      **Response-**
      {
      "hotelId": 2,
      "serviceProviderName": "Paradise Hotels",
      "hotelName": "Paradise",
      "city": "New Delhi",
      "numberOfRoomsAvailable": 2,
      "price": 5600.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      }

7. For updateing Hotel:

   - URL [PUT] http://localhost:9999/hotel/{id}
   - Request Body- hotel object
   - Example:

   1. **Request-**
      url: http://localhost:9999/hotel/2
      Request Body:
      {
      "serviceProviderName": "Paradise Hotels",
      "hotelName": "Paradise",
      "city": "New Delhi",
      "numberOfRoomsAvailable": 2,
      "price": 5600,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      }
      **Response-**
      {
      "hotelId": 2,
      "serviceProviderName": "Paradise Hotels",
      "hotelName": "Paradise",
      "city": "New Delhi",
      "numberOfRoomsAvailable": 2,
      "price": 5600.0,
      "checkInDate": "2023-03-23",
      "checkInTime": "13:00:00",
      "checkOutDate": "2023-03-24",
      "checkOutTime": "12:00:00",
      "wishlist": false,
      "booked": false
      }

8. For deleting Hotel:
   -URL [DELETE] http://localhost:9999/hotel/{id}
   -Example:

   1. **Request-**
      url : http://localhost:9999/hotel/4
      **Response-**
      -Successfully Deleted!!,HttpStatus.OK

9. Add Hotel Service Providers:

   - URL [POST] http://localhost:9999/hotel/serviceProvider
   - Request Body - Service provider object
   - Example:

   1. **Request-**  
       url: http://localhost:9999/hotel/serviceProvider
      Request body:
      {
      "serviceProviderName": "Lemon Tree Hotels",
      "serviceProviderEmail": "lemontreehotels.com",
      "serviceProviderNumber": 6456234567
      }
      **Response-**
      {
      "serviceProviderId": 1,
      "serviceProviderName": "Lemon Tree Hotels",
      "serviceProviderEmail": "lemontreehotels.com",
      "serviceProviderNumber": "6456234567"
      }
   2. **Request-**  
      url: http://localhost:9999/hotel/serviceProvider
      Request body:
      {
      "serviceProviderName": "Paradise Hotels",
      "serviceProviderEmail": "paradisehotes.com",
      "serviceProviderNumber": "123456789"
      }
      **Response-**
      {
      "serviceProviderId": 2,
      "serviceProviderName": "Paradise Hotels",
      "serviceProviderEmail": "paradisehotes.com",
      "serviceProviderNumber": "123456789"
      }

10. List of Servide Providers By Name:

- URL [GET] http://localhost:9999/hotel/serviceProvider/{name}
- Example:

  1.  **Request-** When Service provider name exists
      url: http://localhost:9999/hotel/serviceProvider/Paradise Hotels
      **Response-**
      {
      "serviceProviderId": 2,
      "serviceProviderName": "Paradise Hotels",
      "serviceProviderEmail": "paradisehotes.com",
      "serviceProviderNumber": "123456789"
      }
      2 .**Request-** When Service provider name does not exists
      url: http://localhost:9999/hotel/serviceProvider/Hello world
      **Response-**
      Status 500

11. Booking Hotel:

        - URL [POST] http://localhost:9999/hotel/booking
        - Request Body -
        - Example:

        1.  **Request-**
             url: http://localhost:9999/hotel/booking
            **Request body:**
            {
            "customerEmail": "kritikasingh6421@gmail.com",
            "hotel": {
            "hotelId": 2,
            "hotelName": "Paradise",
            "city": "New Delhi",
            "checkInDate": "2023-03-23"
            },
            "payment": {},
            "order": {},
            "numberOfRoomBook":2
            }
            **Response-**
            {
        "customerEmail": "kritikasingh6421@gmail.com",
        "hotel": {
            "hotelId": 2,
            "serviceProviderName": "Paradise Hotels",
            "hotelName": "Paradise",
            "city": "New Delhi",
            "numberOfRoomsAvailable": 0,
            "price": 5600.0,
            "checkInDate": "2023-03-23",
            "checkInTime": "13:00:00",
            "checkOutDate": "2023-03-24",
            "checkOutTime": "12:00:00",
            "wishlist": true,
            "booked": true
        },
        "payment": {
            "paymentId": 2,
            "transactionId": "0820ba83-f2d2-4f51-91de-a9147e5da5ba",
            "orderId": 4,
            "customerEmail": "kritikasingh6421@gmail.com",
            "totalAmount": 5600.0,
            "paymentDate": "2023-03-28",
            "paymentTime": "15:28:50.2961428",
            "paymentStatus": "Successful"
        },
        "order": {
            "orderId": 4,
            "productId": 2,
            "serviceProviderName": "Paradise Hotels",
            "customerEmail": "kritikasingh6421@gmail.com",
            "transactionId": "0820ba83-f2d2-4f51-91de-a9147e5da5ba",
            "totalAmount": 5600.0,
            "orderDate": "2023-03-28",
            "orderTime": "15:28:50.2132986",
            "orderStatus": "order successful",
            "numberOfRoomBook": 2
        },
        "numberOfRoomBook": 2

    }

    2. **Request-** When data not match with user input
       {
       "customerEmail": "kritikasingh6421@gmail.com",
       "hotel": {
       "hotelId": 2,
       "hotelName": "Paradise",
       "city": "Delhi",
       "checkInDate": "2023-03-23"
       },
       "payment": {},
       "order": {},
       "numberOfRoomBook":2
       }
       **Response-**
       Bad Request Http Status-400

12. Cancel Booking:
    -URL [POST] http://localhost:9999/hotel/bookingCancel
    -Request Body : Order
    -Example-

    1.  **Request-**

    - url: http://localhost:9999/hotel/bookingCancel
    - Request Body: {
      "orderId": 3,
      "productId": 2,
      "serviceProviderName": "Paradise Hotels",
      "customerEmail": "kritikasingh6421@gmail.com",
      "transactionId": "c59444e9-34a8-40d6-b523-af071a00447a",
      "totalAmount": 5600.0,
      "orderDate": "2023-03-27",
      "orderTime": "21:08:35.5593026",
      "orderStatus": "order successful",
      "numberOfRoomBook": 2
      }
      **Response-**
      {
      "orderId": 3,
      "productId": 2,
      "serviceProviderName": "Paradise Hotels",
      "customerEmail": "kritikasingh6421@gmail.com",
      "transactionId": "c59444e9-34a8-40d6-b523-af071a00447a",
      "totalAmount": 5600.0,
      "orderDate": "2023-03-27",
      "orderTime": "21:08:35.5593026",
      "orderStatus": "order cancel",
      "numberOfRoomBook": 2
      }

13. All Orders by customer:

    - URL [GET] http://localhost:9999/hotel/order/{email}

    1.  **Request-**
        url - http://localhost:9999/hotel/order/kritikasingh6421@gmail.com

            **Response-**
            [
            {
                "orderId": 3,
                "productId": 2,
                "serviceProviderName": "Paradise Hotels",
                "customerEmail": "kritikasingh6421@gmail.com",
                "transactionId": "c59444e9-34a8-40d6-b523-af071a00447a",
                "totalAmount": 5600.0,
                "orderDate": "2023-03-27",
                "orderTime": "21:08:35",
                "orderStatus": "order successful",
                "numberOfRoomBook": 2
            }

    ]
