#!/bin/sh
cd $(dirname $0)

cd ..

./mvnw clean package
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf target

./mvnw clean install dockerfile:build
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf target


exit
