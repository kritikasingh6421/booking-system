## **API Endpoints:**

### Payment:

1. All Payments:

- URL [GET] http://localhost:9999/payment/
  **Response-**
  [
  {
  "paymentId": 1,
  "transactionId": "c59444e9-34a8-40d6-b523-af071a00447a",
  "orderId": 3,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 5600.0,
  "paymentDate": "2023-03-27",
  "paymentTime": "21:08:35",
  "paymentStatus": "payment cancel"
  },
  {
  "paymentId": 2,
  "transactionId": "0820ba83-f2d2-4f51-91de-a9147e5da5ba",
  "orderId": 4,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 5600.0,
  "paymentDate": "2023-03-28",
  "paymentTime": "15:28:50",
  "paymentStatus": "Successful"
  },
  {
  "paymentId": 3,
  "transactionId": "6539d63e-e65b-46c0-a31d-59761961c10e",
  "orderId": 1,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 5500.0,
  "paymentDate": "2023-03-28",
  "paymentTime": "16:08:43",
  "paymentStatus": "payment cancel"
  },
  {
  "paymentId": 4,
  "transactionId": "20de33b3-c79e-4a6f-b1df-e420c105441c",
  "orderId": 4,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 8006.0,
  "paymentDate": "2023-03-28",
  "paymentTime": "16:38:14",
  "paymentStatus": "payment cancel"
  }
  ]

2. Payment by customer email:

- URL [GET] http://localhost:9999/payment/findByCustomerEmail?customerEmail={value}
  **Request:** http://localhost:9999/payment/findByCustomerEmail?customerEmail=kritikasingh6421@gmail.com
  **Response-**
  [
  {
  "paymentId": 1,
  "transactionId": "c59444e9-34a8-40d6-b523-af071a00447a",
  "orderId": 3,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 5600.0,
  "paymentDate": "2023-03-27",
  "paymentTime": "21:08:35",
  "paymentStatus": "payment cancel"
  },
  {
  "paymentId": 2,
  "transactionId": "0820ba83-f2d2-4f51-91de-a9147e5da5ba",
  "orderId": 4,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 5600.0,
  "paymentDate": "2023-03-28",
  "paymentTime": "15:28:50",
  "paymentStatus": "Successful"
  },
  {
  "paymentId": 3,
  "transactionId": "6539d63e-e65b-46c0-a31d-59761961c10e",
  "orderId": 1,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 5500.0,
  "paymentDate": "2023-03-28",
  "paymentTime": "16:08:43",
  "paymentStatus": "payment cancel"
  },
  {
  "paymentId": 4,
  "transactionId": "20de33b3-c79e-4a6f-b1df-e420c105441c",
  "orderId": 4,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 8006.0,
  "paymentDate": "2023-03-28",
  "paymentTime": "16:38:14",
  "paymentStatus": "payment cancel"
  }
  ]

3. Payment with respect to order:

- URL [GET] http://localhost:9999/payment/findByOrderId?orderId={value}
  **Request:** http://localhost:9999/payment/findByOrderId?orderId=4
  **Response:**[
  {
  "paymentId": 2,
  "transactionId": "0820ba83-f2d2-4f51-91de-a9147e5da5ba",
  "orderId": 4,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 5600.0,
  "paymentDate": "2023-03-28",
  "paymentTime": "15:28:50",
  "paymentStatus": "Successful"
  },
  {
  "paymentId": 4,
  "transactionId": "20de33b3-c79e-4a6f-b1df-e420c105441c",
  "orderId": 4,
  "customerEmail": "kritikasingh6421@gmail.com",
  "totalAmount": 8006.0,
  "paymentDate": "2023-03-28",
  "paymentTime": "16:38:14",
  "paymentStatus": "payment cancel"
  }
  ]
