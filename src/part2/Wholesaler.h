#pragma once 

#include <string>
#include <vector>  
#include "Grower.h"
#include "FlowersBouquet.h"
#include "Person.h"

 
class Wholesaler : public Person {
private:
	Grower* grower;

public:
	Wholesaler(std:: string name, Grower* grower);
	FlowersBouquet* acceptOrder(std::vector<std::string> flowers);

};
