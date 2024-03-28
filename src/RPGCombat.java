public class RPGCombat {

    public static class Character {
        private String name;
        private int health;

        public Character(String name, int health) {
            this.name = name;
            this.health = health;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public void takeDamage(int damage) {
            health -= damage;
        }
    }

    //Start Combat
    public void startCombat(Character player, Character enemy) {
        System.out.println("Combat begins between " + player.getName() + " and " + enemy.getName() + "!\n");

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            int playerAttackDamage = calculateAttackDamage(10, 20);
            enemy.takeDamage(playerAttackDamage);
            System.out.println(player.getName() + " attacks " + enemy.getName() + "! "
                    + enemy.getName() + "'s health: " + enemy.getHealth());

            if (enemy.getHealth() <= 0) {
                System.out.println(enemy.getName() + " defeated!");
                break;
            }

            int enemyAttackDamage = calculateAttackDamage(5, 15);
            player.takeDamage(enemyAttackDamage);
            System.out.println(enemy.getName() + " attacks " + player.getName() + "! "
                    + player.getName() + "'s health: " + player.getHealth());

            if (player.getHealth() <= 0) {
                System.out.println(player.getName() + " defeated!");
                break;
            }
        }
    }

    private int calculateAttackDamage(int minDamage, int maxDamage) {
        return (int) (Math.random() * (maxDamage - minDamage + 1)) + minDamage;
    }

    public static void main(String[] args) {
        RPGCombat combat = new RPGCombat();
        Character tyrion = new Character("Tyrion Fordring", 100);
        Character garrosh = new Character("Garrosh Hellscream", 150);
        combat.startCombat(tyrion, garrosh);
    }
}