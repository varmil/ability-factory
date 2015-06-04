// 参考：https://www.ogis-ri.co.jp/otc/hiroba/technical/DesignPatternsWithExample/chapter04.html

/**
 * 抽象ファクトリ
 */
public abstract class AbilityFactory {

	public Ability create() {

		// インスタンス生成共通処理 .....

		Ability ability = createAbility();

		return ability;
	}

	/**
	 * TODO これ適切？ CSVのアビリティタイプを受け取って、適切な具象Factoryを返す
	 */
	public static AbilityFactory get(String type) {
		// TODO
		return
	}

	/**
	 * 具象インスタンス生成メソッド（abstract）
	 */
	abstract protected Ability createAbility();
}

/**
 * 具象ファクトリ
 */
public class AttackUpFactory extends AbilityFactory {

	protected Ability createAbility() {

		// インスタンス生成個別処理 .....

		return new AttackUp();
	}
}

/**
 * 具象Product
 */
public class AttackUp extends Ability {

	public void execute() {
		// アビリティ実行処理
	}
}






/**
 * Client
 */
public class Attack extends Logic {

	// 本当はこんな感じでメンバ変数を以って、コンストラクタ引数で実行したい具象Factoryを渡す
	// private AbilityFactory abilityFactory;

	public void ability() {
		.....

		// TODO 具象ファクトリをどうやって取得するのが綺麗か？ Facadeパターン？
		AbilityFactory abilityFactory = AbilityFactory.get('attack_up');

		// 具象Product取得
		Ability ability = abilityFactory.create();

		// アビリティ実行
		ability.execute();

		.....
	}
}