#ifndef GARDENER_H
#define GARDENER_H

#include <string>
#include <vector>
#include "FlowersBouquet.h"

class Gardener {
private:
    std::string name;

public:
    Gardener(std::string name);

    FlowersBouquet* prepareBouquet(std::vector<std::string> flowers);

};

#endif