#ifndef Florsit.h
#define Florist.h
#include "Wholesaler.h"
#include "FlowerArranger.h"
#include "DeliveryPerson.h"
#include <vector>
#include <string>
#include "Person.h"
class Florist : public Person
{
private:
	Wholesaler wholesaler*;
	FlowerArranger flowerArranger*;
	DeliveryPerson deliveryPerson*;
};
public:
	Florist(std::string name, Wholesaler* wholesaler, FlowerArranger* flowerArranger, DeliveryPerson* deliveryPerson);
	void acceptOrder(Person*  recipient, std::vector<std::string> flowers)
#endif // !Florsit.h


