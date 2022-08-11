# demo-1

Sample Project to show that Spring Framework FieldError logs sensitive data.

## Usage

1. Start the project as spring boot application
1. Run the following command to send some data that fails validation

    ```
    curl --request POST \
      --url http://localhost:8080/payment-cards \
      --header 'Content-Type: application/json' \
      --data '{
    	"id": "4",
    	"accountNumber": "4444333322221112",
    	"expirationDate": "2022-12",
    	"accountHolder": "Jimmy Doe",
    }'
    ```

1. Check log file of spring boot application. It will contain the following log event as rejectedValue [<sensitive data>]:

    ```
    2022-08-11 19:35:56.283  WARN 1 --- [nio-8080-exec-2] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument [0] in public com.example.demo.domain.PaymentCard com.example.demo.api.CardController.saveCard(com.example.demo.domain.PaymentCard): [Field error in object 'paymentCard' on field 'accountNumber': rejected value [4444333322221112]; codes [CreditCardNumber.paymentCard.accountNumber,CreditCardNumber.accountNumber,CreditCardNumber.java.lang.String,CreditCardNumber]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [paymentCard.accountNumber,accountNumber]; arguments []; default message [accountNumber],false]; default message [invalid credit card number]] ]
    ```