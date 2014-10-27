cd $HOME/Documents/workspace/util/target/classes
jar cf ../util.jar .
cp ../util.jar $HOME/Documents/Processing/libraries/util/library
cp ../util.jar $HOME/Documents/workspace/sojamo
echo "net.sojamo.util compiled on $(date)"
