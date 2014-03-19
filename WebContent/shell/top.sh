 #!/bin/bash
Date=$(date +%Y%m%d)
mkdir $2${Date}
top -b -n 1 > $2${Date}/$1
echo nice >> $2${Date}/$1