#include <string>  
#include <vector>  
#include "Gardener.h"
#include "FlowersBouquet.h"
#include "Person.h"
#include <iostream> 
Grower::Grower(std::string name, Gardener* gardener)
	: Person(name), gardener(gardener)}
	{
	}
	FlowersBouquet*  Grower::prepareOrder(std::vector<std::string>) flowers){
		std::cout << "Grower " << getName() << " forwards the request to" << "Gardener" << gardener->getName() << std::endl;
		FlowersBouquet* bouquet = gardener->prepareBouquet(flowers);
		std::cout << "Grower " << name << " returns flowers to Wholesaler." << std::endl;
		return bouquet;
	}