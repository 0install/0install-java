#!/bin/bash
set -e
cd `dirname $0`

rm -rf ../target/doc
mkdir -p ../target/doc

0install run http://repo.roscidus.com/devel/doxygen

cp .nojekyll CNAME ../target/doc/
