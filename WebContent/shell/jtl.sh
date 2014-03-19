#!/bin/bash
Date=$(date +%Y%m%d)
jmeterPath=/opt/apps/jmeter
logName=$1/log/${Date}/JM$2
jtlName=$1/upFile/JTL$2
mkdir $1/log/${Date}
echo JTL parse start... > $logName
/bin/bash $jmeterPath/lib/ext/JMeterPluginsCMD.sh --tool Reporter --generate-png $1/log/${Date}/JMRT$2.png --input-jtl $jtlName --plugin-type ResponseTimesOverTime --width 1200 --height 600
/bin/bash $jmeterPath/lib/ext/JMeterPluginsCMD.sh --tool Reporter --generate-png $1/log/${Date}/JMTPS$2.png --input-jtl $jtlName --plugin-type HitsPerSecond --width 1200 --height 600
/bin/bash $jmeterPath/lib/ext/JMeterPluginsCMD.sh --tool Reporter --generate-png $1/log/${Date}/JMBT$2.png --input-jtl $jtlName --plugin-type BytesThroughputOverTime --width 1200 --height 600
echo SOHUTESTDATE${Date}========JMETERFINISHED========SOHUTESTID$2 >> $logName
