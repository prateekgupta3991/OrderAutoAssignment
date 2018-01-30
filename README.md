# order assignment
Order auto assignment among delivery executives

Steps to run :
1. mvn clean install
2. mvn tomcat7:run

Have set the area threshold to 500km as per the following (change in Constant.java as per requirement and input)

input
{
	"des": [
		{
			"id": 123,
			"last_order_delivered_time": 1517245300,
			"current_location": "47.6788206,-122.3271205"
		},
		{
			"id": 321,
			"last_order_delivered_time": 1517245354,
			"current_location": "49.6788206,-129.3271205"
		},
		{
			"id": 323,
			"last_order_delivered_time": 1517245354,
			"current_location": "50.6788206,-132.3271205"
		},
		{
			"id": 231,
			"last_order_delivered_time": 1517245354,
			"current_location": "45.6788206,-118.3271205"
		},
		{
			"id": 256,
			"last_order_delivered_time": 1517245354,
			"current_location": "39.6788206,-116.3271205"
		},
		{
			"id": 577,
			"last_order_delivered_time": 1517245354,
			"current_location": "49.6788206,-125.3271205"
		},
		{
			"id":845,
			"last_order_delivered_time": 1517245219,
			"current_location": "56.6788206,-122.3271205"
		}
	],
	"orders": [
		{
			"id": 809,
			"ordered_time": 1517245354,
			"restaurant_location": "50.6788206,-128.3271205"
		},
		{
			"id": 810,
			"ordered_time": 1517245300,
			"restaurant_location": "48.6788206,-127.3271205"
		},
		{
			"id": 811,
			"ordered_time": 1517245220,
			"restaurant_location": "47.6788206,-135.3271205"
		},
		{
			"id": 812,
			"ordered_time": 1517245290,
			"restaurant_location": "42.6788206,-156.3271205"
		},
		{
			"id": 813,
			"ordered_time": 1517245120,
			"restaurant_location": "53.6788206,-125.3271205"
		}
	]
}

output
{
    "assignments": [
        {
            "order_id": 813,
            "de_id": 845
        },
        {
            "order_id": 811,
            "de_id": 577
        },
        {
            "order_id": 810,
            "de_id": 123
        },
        {
            "order_id": 809,
            "de_id": 323
        }
    ]
}
