#ifndef Grower_H
#define Grower_H
#include <string>  
#include <vector>  
#include <Gardener.h>
#include <FlowersBouquet.h>
#include <Person.h>


class Grower : public Person {
private:
	Gardener* gardener;

	};
public:
	Grower(std::string name ,Gardener* gardener)
     FlowersBoquet* prepareOrder(std::vector<std::string>) flowers)
}

#endif // !Grower_H