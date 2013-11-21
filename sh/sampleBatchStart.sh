#!/bin/sh

# Batch process check script - start
declare -i processCnt
processCnt=`ps -ef | grep BatchMain | grep -v "grep BatchMain" | wc -l`
if [ $processCnt -ge 1 ]
then
        echo "BatchMain already started !!"
        exit 0
fi
# fishing batch process check script - end

JAVA_HOME=/usr/local/java
BASEDIR=/usr/local/app/sampleBatch
PROGRAM_NAME=sample.batch.main.BatchMain
STOP_FILE_PATH=${BASEDIR}/sh/stop.txt

export JAVA_HOME

for f in `find $BASEDIR/lib -type f -name "*.jar"`
do
   CLASSPATH=$CLASSPATH:$f
done
CLASSPATH=${CLASSPATH}:${BASEDIR}/lib/sampleBatch.jar

if test -f ${STOP_FILE_PATH}; then
    rm ${STOP_FILE_PATH}
fi

cd ${BASEDIR}/bin

JAVA_BIN=${JAVA_HOME}/bin/java
OPT="-server -Xmx128m -Xms128m -Xmn64m -classpath ${CLASSPATH} "

$JAVA_BIN $OPT ${PROGRAM_NAME} &

echo "sampleBatch start"

exit 0