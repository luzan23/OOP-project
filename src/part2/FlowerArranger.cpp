#include "FlowersBouquet.h"
#include "Person.h"
#include "FlowerArranger.h"
#include <vector>
#include <string>
#include <iostream>
FlowerArranger::FlowerArranger(std::string name) : Person(name)
{

}

void FlowerArranger::arrangeFlowers(FlowersBouquet* bouquet){
	std::cout << "Flower Arranger " << getName() << " arranges flowers" << std::endl;
}