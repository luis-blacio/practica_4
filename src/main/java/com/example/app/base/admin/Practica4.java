package  com.example.app.base.admin;

import com.example.app.base.Controler.data_struct.list.Linkendlist;

public class Practica4 {
    
    public String generar(int r, int c) throws Exception {
        
        StringBuilder s = new StringBuilder(c);
        for (int x = 0; x < c; x++) {
            s.append('0');
        }
        char[][] maz = new char[r][c];
        for (int x = 0; x < r; x++) {
            maz[x] = s.toString().toCharArray();
        }

        
        Point st = new Point((int) (Math.random() * r), (int) (Math.random() * c), null);
        maz[st.r][st.c] = 'S';

        
        Linkendlist<Point> frontier = new Linkendlist<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0 || x != 0 && y != 0) {
                    continue;
                }
                try {
                    if (maz[st.r + x][st.c + y] == '1') {
                        continue;
                    }
                } catch (Exception e) { 
                    continue;
                }
                
                frontier.add(new Point(st.r + x, st.c + y, st));
            }
        }

        Point last = null;
        while (!frontier.isEmpty()) {

            
            Point cu = frontier.delete((int) (Math.random() * frontier.getLength()));
            Point op = cu.opposite();
            try {
               
                if (maz[cu.r][cu.c] == '0') {
                    if (maz[op.r][op.c] == '0') {

                        
                        maz[cu.r][cu.c] = '1';
                        maz[op.r][op.c] = '1';

                        
                        last = op;

                        
                        for (int x = -1; x <= 1; x++) {
                            for (int y = -1; y <= 1; y++) {
                                if (x == 0 && y == 0 || x != 0 && y != 0) {
                                    continue;
                                }
                                try {
                                    if (maz[op.r + x][op.c + y] == '1') {
                                        continue;
                                    }
                                } catch (Exception e) {
                                    continue;
                                }
                                frontier.add(new Point(op.r + x, op.c + y, op));
                            }
                        }
                    }
                }
            } catch (Exception e) { 
            }

            if (frontier.isEmpty() && last != null) {
                maz[last.r][last.c] = 'E';
            }
        }

        s = new StringBuilder();
        for (int i = 0; i < r; i++) {
            String aux = "";
            for (int j = 0; j < c; j++) {
                 aux += maz[i][j]+",";
            }
            aux = aux.substring(0,aux.length()-1);
            s.append(aux).append("\n");
        }
        
       
        
      
        return s.toString();
    }
    
    // Clase interna para representar un punto en el laberinto
    private static class Point {
        public int r, c;
        public Point parent;
        
        public Point(int r, int c, Point parent) {
            this.r = r;
            this.c = c;
            this.parent = parent;
        }
        
        public Point opposite() {
            if (parent == null) {
                return null;
            }
            int dr = r - parent.r;
            int dc = c - parent.c;
            return new Point(r + dr, c + dc, this);
        }
    }
}