//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println("Hello and welcome!");

    Point1 p = new Point1(37, 11);
    IO.println("p: x = " + p.getX() + ", y = " + p.getY());

    boolean identity = Objects.hasIdentity(p);
    IO.println("p has identity: " + identity);

    Point2 rp = new Point2(3, 4);
    IO.println("rp: x = " + rp.x() + ", y = " + rp.y());

    identity = Objects.hasIdentity(rp);
    IO.println("rp has identity: " + identity);
}
