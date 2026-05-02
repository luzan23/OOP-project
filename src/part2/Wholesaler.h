#ifndef Wholesaler_H
#define Wholesaler_H
#include <string>
#include <vector>  
#include <Grower.h>
#include <FlowerBouquet.h>
 
class Wholesaler
{
private:
	Grower* grower;

};
public:
	Wholesaler(Grower grower);
	FlowersBouquet* acceptOrder(std::vector<std::string> flowers)
	
#endif // !Wholesaler_H


