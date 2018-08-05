
public class BitMask {

    public int fourSideBitMapCalculator( LandSquareTile tile,  LandSquareTile[][] map){ //calculates  the  bitmap value for tile based on wether or  the 4  compass directions are the same as it
        int bitMapValue = 0;                    // then returns the value
        int bitValues=0;
 int xSize=map.length;
 int ySize=map[0].length;

        for (int county = -1; county < 2; county++) {
            for (int countx = -1; countx < 2; countx++) {
                if (!(countx != 0 && county != 0) || (countx==0 && county==0)) {

                    continue;


                }
                if(bitValues==0) {
                    bitValues=1;

                }
                else {

                    bitValues=bitValues*2;
                }

                int x=countx+tile.getLocationx();
                int y=county+tile.getLocationy();
                if (y>=0 && y<ySize && x>=0 && x<xSize) {

                    LandSquareTile tile2 = map[x][ y];
                    if (tile2.getClass() == tile.getClass()) {

                        bitMapValue = bitMapValue + bitValues;
                    }
                }


                bitValues=bitValues*2;

            }


        }


        return bitMapValue;
    }
    public int eightSideBitMapCalculator( LandSquareTile tile,  LandSquareTile[][] map){  // does the same thing  as the previous function but for all eight directions
        int xSize=map.length;
        int ySize=map[0].length;
        boolean [] [] bitMap = new boolean [3] [3];

        for (int county = -1; county < 2; county++) {
            for (int countx = -1; countx < 2; countx++) {

                int x=countx+tile.getLocationx();
                int y=county+tile.getLocationy();
                if (y>=0 && y<ySize && x>=0 && x<xSize) {

                    LandSquareTile tile2 = map[x][ y];
                    if (tile2.getClass() == tile.getClass()) {
                        bitMap[countx+1][county+1]=true;


                    }
                }

            }


        }
        int bitMapValue=eightBitConverter(bitMap);


        return bitMapValue;


    }



    public int fourSideBitMapCalculator( LandSquareTile tile, Things thing,  LandSquareTile[][] map){ //calculates  the  bitmap value for tile based on wether or  not  the tiles in  4  compass directions contain the same thing

        if (thing==null){
            return 0;

        }
        int xSize=map.length;
        int ySize=map[0].length;


        int bitMapValue = 0; // total
        int bitValues=0; // the value for the adjecant numbers


        for (int county = -1; county < 2; county++) {
            for (int countx = -1; countx < 2; countx++) {
                if (!(countx != 0 && county != 0) || (countx==0 && county==0)) {

                    continue;


                }
                if(bitValues==0) {
                    bitValues=1;

                }
                else {

                    bitValues=bitValues*2;
                }
                int x=countx+tile.getLocationx();
                int y=county+tile.getLocationy();
                if (y>=0 && y<ySize && x>=0 && x<xSize) {

                    LandSquareTile tile2 = map[x][y];
                    ArrayList<Things> things = tile.getAllThings();
                    boolean hasThing = new NameCheck().checkThings(thing.getName(), things);
                    if (hasThing == true) {

                        bitMapValue = bitMapValue + bitValues;
                    }
                }
                bitValues=bitValues*2;

            }


        }


        return bitMapValue;











    }

    public int eightSideBitMapCalculator( LandSquareTile tile, Things thing,  LandSquareTile[][] map){ // does the smae as pervious function but for all eight sides

        if (thing==null){
            return 0;

        }
        int xSize=map.length;
        int ySize=map[0].length;

        boolean [] [] bitMap = new boolean [3] [3];


        for (int county = -1; county < 2; county++) {
            for (int countx = -1; countx < 2; countx++) {


                int x=countx+tile.getLocationx();
                int y=county+tile.getLocationy();
                if (y>=0 && y<ySize && x>=0 && x<xSize) {

                    LandSquareTile tile2 = map[x][y];
                    ArrayList<Things> things = tile.getAllThings();
                    boolean hasThing = new NameCheck().checkThings(thing.getName(), things);
                    if (hasThing == true) {
                        bitMap[countx+1][county+1]=true;

                    }
                }

            }


        }
        int bitMapValue=eightBitConverter(bitMap);


        return bitMapValue;











    }

    private  int eightBitConverter(boolean [][]  map){ // converts  a array of boolean s for adjecent tiles on whether or not  they match the center tile  and then  retuns the value

        int bitMapValue = 0;                    // then returns the value
        int bitValues=0;




        for (int countx = 0; countx < 3; countx++) {
            for (int county = 0; county < 3; county++) {
                if ( (countx==1 && county==1)) {
                    continue;

                }
                if(bitValues==0) {
                    bitValues=1;

                }
                else {

                    bitValues=bitValues*2;
                }

                if (map[countx][county]==true) {
                    if (county==0 && countx==0 && map[0][1]==true && map[1][0]==true) {
                        bitMapValue = bitMapValue + bitValues;

                        continue;
                    }
                    else if(county==0 && countx==0 ) {
                        continue;


                    }
                    else if (county==0 && countx==2 && map[2][1]==true && map[1][0]==true) {
                        bitMapValue = bitMapValue + bitValues;

                        continue;
                    }
                    else if(county==0 && countx==2 ) {
                        continue;


                    }
                    else if (county==2 && countx==0 && map[0][1]==true && map[1][2]==true) {
                        bitMapValue = bitMapValue + bitValues;


                        continue;
                    }
                    else if(county==2 && countx==0 ) {
                        continue;


                    }
                    else if (county==2 && countx==2 && map[2][1]==true && map[1][2]==true) {
                        bitMapValue = bitMapValue + bitValues;

                        continue;
                    }
                    else if(county==2 && countx==2 ) {
                        continue;


                    }

                    bitMapValue = bitMapValue + bitValues;


                }





            }


        }
        return bitMapValue;


    }


}


}
