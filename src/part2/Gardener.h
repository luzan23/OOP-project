#ifndef GARDENER_H
#define GARDENER_H

#include <string>
#include <vector>
#include "FlowersBouquet.h"
#include "Person.h"

class Gardener : public Person{
public:
    Gardener(std::string name);

    FlowersBouquet* prepareBouquet(std::vector<std::string> flowers);

};

#endif