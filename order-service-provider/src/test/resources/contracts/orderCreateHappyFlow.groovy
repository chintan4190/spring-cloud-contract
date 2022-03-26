package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/providers/calculations'
        headers {
            contentType(applicationJson())
        }
        body(
                itemName: $(anyNonBlankString()),
                quantity: $(anyPositiveInt()),
              //  id: $(anyNumber())
        )
    }
    response {
        headers {
            contentType(applicationJson())
        }
        status OK()
        body(
                totalAmount: "1000",
                available: true
        )
    }
}
