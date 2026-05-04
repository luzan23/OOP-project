#include <string>  
#include <vector>  
#include "Grower.h"
#include "FlowersBouquet.h"
#include "Person.h"
#include <iostream> 
Wholesaler::Wholesaler(std::string name, Grower* grower)
	: Person(name), grower(grower)
	{
	}

	FlowersBouquet* Wholesaler::prepareOrder(std::vector<std::string> flowers){
		std::cout << "Wholesaler " << getName() << " forwards the request to Grower " << grower->getName() << std::endl;
		return grower->prepareOrder(flowers);
	}