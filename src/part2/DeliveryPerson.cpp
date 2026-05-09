#include "Person.h"
#include "FlowersBouquet.h"
#include "DeliveryPerson.h"
#include <string>
#include <vector>
#include <iostream>

DeliveryPerson::DeliveryPerson(std::string name) : Person(name){}

void DeliveryPerson::deliver(Person* recipient, FlowersBouquet* bouquet){
	std:: cout << "Delivery Person " << getName() << " delivers flowers to " << recipient->getName() << std::endl;
	recipient->acceptFlowers(bouquet);
}