#!/bin/bash

python -c "from demo5 import hello; hello()"

str=$(python -c "from demo5 import hello2; hello2()")
echo ${str}
