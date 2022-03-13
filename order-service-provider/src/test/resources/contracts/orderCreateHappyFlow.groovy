package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/orders'
        headers {
            contentType(applicationJson())
        }
        body '''\
		{ "itemName": "mobile", "quantity": "3" }
	'''
    }
    response {
        headers {
            contentType(applicationJson())
        }
        status OK()
        body """{"totalAmount": "1000","available": true}"""
    }
}
