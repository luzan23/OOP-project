#include "Florist.h"
#include "Person.h"
#include "Wholesaler.h"
#include "FlowerArranger.h"
#include "DeliveryPerson.h"
#include "FlowersBouquet.h"
#include <iostream>
#include <vector>
#include <string>

Florist::Florist(std::string name, Wholesaler* wholesaler, FlowerArranger* flowerArranger, DeliveryPerson* deliveryPerson) :
	Person(name), wholesaler(wholesaler), flowerArranger(flowerArranger), deliveryPerson(deliveryPerson){}

	void Florist::acceptOrder(Person* recipient, std::vector<std::string> flowers){
		std::cout<< "Florist " << name << " forwards request to Wholesaler "<< wholesaler->getName()<<std::endl;
		FlowersBouquet* bouquet = wholesaler->prepareOrder(flowers);
		std::cout<< "Wholesaler " << wholesaler->getName() << " returns flowers to Florist "<< getName()<<std::endl;
		std::cout<< "Florist " << name << " request flowers arrangement from Flower Arranger "<< flowerArranger->getName()<<std::endl;
		flowerArranger->arrangeFlowers(bouquet);
		std::cout<< "Flower Arranger " <<flowerArranger->getName() << " returns arranged flowers to Florist " name << std::endl;
		deliveryPerson->deliver(recipient, bouquet);

	}