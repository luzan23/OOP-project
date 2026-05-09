#include "FlowersBouquet.h"
#include "Person.h"
#include "FlowerArranger.h"
#include <vector>
#include <string>
#include <iostream>

void FlowerArranger::arrangeFlowers(FlowersBouquet* bouquet){
	std::cout << "Flower Arranger " << getName() << " arranges flowers" << std::endl;
	bouquet->arrange(); 
	std::cout << "Flower Arranger " << name << " returns arranged flowers to Florist. " << std::endl;
}

}