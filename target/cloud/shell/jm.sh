#!/bin/bash
Date=$(date +%Y%m%d)
jtlName=$1/log/${Date}/JTL$2
logName=$1/log/${Date}/JM$2
jmeterPath=/opt/jmeter
mkdir $1/log/${Date}
/bin/bash $jmeterPath/bin/jmeter -n -t $1/tmp/JMX$2 -l $1/log/${Date}/JTL$2 > $logName
/bin/bash $jmeterPath/lib/ext/JMeterPluginsCMD.sh --tool Reporter --generate-png $1/log/${Date}/JMRT$2.png --input-jtl $jtlName --plugin-type ResponseTimesOverTime --width 1000 --height 600
/bin/bash $jmeterPath/lib/ext/JMeterPluginsCMD.sh --tool Reporter --generate-png $1/log/${Date}/JMTPS$2.png --input-jtl $jtlName --plugin-type HitsPerSecond --width 1000 --height 600
/bin/bash $jmeterPath/lib/ext/JMeterPluginsCMD.sh --tool Reporter --generate-png $1/log/${Date}/JMBT$2.png --input-jtl $jtlName --plugin-type BytesThroughputOverTime --width 1000 --height 600
echo SN:SOHUTESTDATE${Date}JMETERFINISHEDSOHUTESTID$2 >> $logName
