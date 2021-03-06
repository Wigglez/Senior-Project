package dragonsreign.scene;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import dragonsreign.scene.BaseScene;
import dragonsreign.util.PartyContainer;
import dragonsreign.util.enums.ITEMTYPE;
import dragonsreign.util.enums.POTIONS;
import dragonsreign.character.PlayerCharacter;
import dragonsreign.character.characterclass.ClericClass;
import dragonsreign.character.characterclass.RangerClass;
import dragonsreign.character.characterclass.WarriorClass;
import dragonsreign.item.Gear;
import dragonsreign.item.Inventory;
import dragonsreign.item.Item;
import dragonsreign.item.consumable.Potion;
import dragonsreign.manager.SceneManager;
import dragonsreign.manager.SceneManager.SceneType;

public class InventoryScene extends PartyContainer {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private MenuScene inventoryChildScene;

	private Sprite playerPortrait[], inventoryArea, inventorySlot[],
			equipmentArea, equipmentSlot[], statsArea, exitButton;

	private Rectangle playerHealthBar[], playerResourceBar[], playerXpBar[];

	private Text playerInfo[];
	
	private PlayerCharacter player[];
	
	private int playerSelected;

	// Inventory
	private int usableSlots;
	private boolean slotOccupied, isFull;

	//Access to game
	GameScene parent;
		
	// ===========================================================
	// Constructors
	// ===========================================================
	InventoryScene(GameScene pParentScene) {
		super();
		parent = pParentScene;
	}
	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public void createScene() {
		camera.setChaseEntity(null);
		camera.offsetCenter(camera.getCenterX() * -1, camera.getCenterY() * -1);

		inventoryChildScene = new MenuScene(camera);
		setChildScene(inventoryChildScene);
		
		// TODO
		// use imported characters
		player = new PlayerCharacter[3];
		
		player[0] = ((DragonsReignActivity) activity).getPartyMember(0);
		player[1] = ((DragonsReignActivity) activity).getPartyMember(1);
		player[2] = ((DragonsReignActivity) activity).getPartyMember(2);
		
		/*
		Log.e("InventoryScene", "getSelectedPlayer = " + getSelectedPlayer());
		if (getSelectedPlayer() == 0) {
			player[0] = getWarriorObj();
			player[1] = getRangerObj();
			player[2] = getClericObj();
			Log.e("InventoryScene", "getWarriorObj = " + getWarriorObj());
			Log.e("InventoryScene", "getRangerObj = " + getRangerObj());
			Log.e("InventoryScene", "getClericObj = " + getClericObj());
		} else if (getSelectedPlayer() == 1) {
			player[0] = getWarriorObj();
			player[1] = getRangerObj();
			player[2] = getClericObj();
			Log.e("InventoryScene", "getWarriorObj = " + getWarriorObj());
			Log.e("InventoryScene", "getRangerObj = " + getRangerObj());
			Log.e("InventoryScene", "getClericObj = " + getClericObj());
		} else if (getSelectedPlayer() == 2) {
			player[0] = getWarriorObj();
			player[1] = getRangerObj();
			player[2] = getClericObj();
			Log.e("InventoryScene", "getWarriorObj = " + getWarriorObj());
			Log.e("InventoryScene", "getRangerObj = " + getRangerObj());
			Log.e("InventoryScene", "getClericObj = " + getClericObj());
		}
		*/

		playerSelected = 0;

		playerHealthBar = new Rectangle[3];
		playerResourceBar = new Rectangle[3];
		playerXpBar = new Rectangle[3];
		playerInfo = new Text[3];
		
		
		
		createPlayerTouchAreas();
		createPlayers();
		createInventoryChildScene();
		createExitButton();
		createInventoryTouchAreas();
		

		// Update the inventory
		updateInventory();
	}

	@Override
	public void onBackKeyPressed() {
//		SceneManager.getInstance().setScene(SceneManager.SceneType.SCENE_GAME);
//
//		camera.setChaseEntity(GameScene.player);
//		camera.updateChaseEntity();
		parent.goBackToGame();
	}

	@Override
	public SceneType getSceneType() {

		return null;
	}

	@Override
	public void disposeScene() {
	}

	// ===========================================================
	// Methods
	// ===========================================================

	public void createInventoryChildScene() {
		// Set up child scene
		createPlayerStatsArea();

		inventoryChildScene.setPosition(0, 140);

		// Create sprites
		statsArea = new Sprite(0, 0, resourcesManager.statsArea,
				this.engine.getVertexBufferObjectManager());
		equipmentArea = new Sprite(0, 0, resourcesManager.equipmentArea,
				this.engine.getVertexBufferObjectManager());
		inventoryArea = new Sprite(0, 0, resourcesManager.inventoryArea,
				this.engine.getVertexBufferObjectManager());

		// Attach entities
		inventoryChildScene.attachChild(equipmentArea);
		inventoryChildScene.attachChild(statsArea);
		inventoryChildScene.attachChild(inventoryArea);

		inventoryChildScene.setBackgroundEnabled(false);

		// Set positions
		statsArea.setPosition(0, 0);
		equipmentArea.setPosition(210, 0);
		inventoryArea.setPosition(420, 0);

		inventoryChildScene.setVisible(true);

		if(player[0] != null) {
			inventoryChildScene.attachChild(playerInfo[0]);
		}
		
		if(player[1] != null) {
			inventoryChildScene.attachChild(playerInfo[1]);
		}
		
		if(player[2] != null) {
			inventoryChildScene.attachChild(playerInfo[2]);
		}
	}

	public void createPlayerTouchAreas() {
		// Player touch areas
		playerPortrait = new Sprite[3];

		if (player[0] != null) {
			playerPortrait[0] = new Sprite(0, 0,
					player[0].getPortrait(),
					this.engine.getVertexBufferObjectManager()) {
				@Override
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
						final float pTouchAreaLocalX,
						final float pTouchAreaLocalY) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						playerSelected = 0;

						updateInventory();

						break;

					}
					return true;

				}
			};

			registerTouchArea(playerPortrait[0]);
		}

		if (player[1] != null) {
			playerPortrait[1] = new Sprite(0, 0,
					player[1].getPortrait(),
					this.engine.getVertexBufferObjectManager()) {
				@Override
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
						final float pTouchAreaLocalX,
						final float pTouchAreaLocalY) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						playerSelected = 1;

						updateInventory();

						// strengthText.setText("Str: " + 555);

						break;

					}
					return true;

				}
			};

			registerTouchArea(playerPortrait[1]);
		}

		if (player[2] != null) {
			playerPortrait[2] = new Sprite(0, 0,
					player[2].getPortrait(),
					this.engine.getVertexBufferObjectManager()) {
				@Override
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
						final float pTouchAreaLocalX,
						final float pTouchAreaLocalY) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						playerSelected = 2;

						updateInventory();

						// strengthText.setText("Str: " + 2000);
						break;

					}
					return true;

				}
			};

			registerTouchArea(playerPortrait[2]);
		}
	}
	
	public void createExitButton() {
		exitButton = new Sprite(0, 0, resourcesManager.exitButton,
				this.engine.getVertexBufferObjectManager()) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN:
					onBackKeyPressed();

					break;

				}
				return true;

			}
		};
		
		// Exit button
		exitButton.setPosition(-12, -12);
		exitButton.setScale(0.5f);
		attachChild(exitButton);

		registerTouchArea(exitButton);
	}
	
	public void createInventoryTouchAreas() {
		// Inventory touch areas
		inventorySlot = new Sprite[25];

		final Inventory currentInventory = ((DragonsReignActivity)activity).getInventory();
		
		int i = 0;
		
		for(int j = 0; j < currentInventory.getMaxInventorySize() / 5; j++) {
			for(int k = 0; k < currentInventory.getMaxInventorySize() / 5; k++) {
				
				if(i < currentInventory.getCurrentInventorySize()) {
					final Item currentItem = currentInventory.getItem(i);
					inventorySlot[i] = new Sprite(0, 0, currentItem.getIcon(), this.engine.getVertexBufferObjectManager()) {
						@Override
						public boolean onAreaTouched(TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
							switch (pSceneTouchEvent.getAction()) {
							case TouchEvent.ACTION_DOWN:
								
								if (currentItem.getClass() == Gear.class) {
									activity.runOnUiThread(new Runnable() {
										public void run() {
											AlertDialog.Builder builder = new AlertDialog.Builder(activity);
											builder.setMessage("Equip " + currentItem.getName() + " on " + player[playerSelected].getName() + "?")
													.setPositiveButton("Equip",	new DialogInterface.OnClickListener() {
																public void onClick(DialogInterface dialog,int id) {
																	Gear[] removeItems = new Gear[2];
																	if(player[playerSelected].equipItem((Gear)currentItem, removeItems)){
																		
																		if(removeItems[0] != null)
																			currentInventory.addItem(removeItems[0]);
																		if(removeItems[1] != null)
																			currentInventory.addItem(removeItems[1]);
																		
																		currentInventory.removeItem(currentItem);
																		updateInventory();
																		createInventoryTouchAreas();
//																		player[playerSelected].getEquipmentSlots().contains(currentItem)
																	} else{
																		writeToScreen("Cannot Equip Item.");
																	}
																}
															})
													.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
																public void onClick(DialogInterface dialog,int id) {
																	//Do Nothing
																}
															});
											AlertDialog dialog = builder.create();
											dialog.show();
										}
									});
								}
								
								break;

							}
							return true;

						}
					};
					
					
					if (k == 0 && j == 0) {
						inventorySlot[i].setPosition(420 + (k * 64), 0 + (j * 64));
						Log.e("InventoryScene k == 0, j == 0", "i = " + i + ", x = " + inventorySlot[i].getX() + ", y = " + inventorySlot[i].getY());
					} else {
						inventorySlot[i].setPosition(420 + (k * 64) + (1 * k), 0 + (j * 64) + (1 * j));
						Log.e("InventoryScene k > 0 || j > 0", "i = " + i + ", x = " + inventorySlot[i].getX() + ", y = " + inventorySlot[i].getY());
					} 

					inventoryChildScene.attachChild(inventorySlot[i]);
					
					registerTouchArea(inventorySlot[i]);
					
					i++;
				}
			}
		}
	}

	public void createPlayers() {
		// Create player one
		if (player[0] != null) {
			playerPortrait[0].setPosition(0, 50);
			attachChild(playerPortrait[0]);

			playerHealthBar[0] = new Rectangle(0, 0,
					player[0].getHealthPercentage(), 20,
					this.engine.getVertexBufferObjectManager());
			playerHealthBar[0].setColor(1.0f, 0, 0);

			playerResourceBar[0] = new Rectangle(0, 0,
					player[0].getResourcePercentage(), 20,
					this.engine.getVertexBufferObjectManager());
			if(player[0].getClass() == WarriorClass.class) {
				playerResourceBar[0].setColor(1.0f, 0.4f, 0.4f);
			} else if(player[0].getClass() == RangerClass.class) {
				playerResourceBar[0].setColor(1.0f, 1.0f, 0);
			} else if(player[0].getClass() == ClericClass.class) {
				playerResourceBar[0].setColor(0, 0, 1.0f);
			}
			
			playerXpBar[0] = new Rectangle(0, 0,
					player[0].getExperiencePercentage(), 20,
					this.engine.getVertexBufferObjectManager());
			playerXpBar[0].setColor(0, 1.0f, 1.0f);

			playerHealthBar[0].setPosition(60, 50);
			playerResourceBar[0].setPosition(60, 70);
			playerXpBar[0].setPosition(60, 90);

			attachChild(playerHealthBar[0]);
			attachChild(playerResourceBar[0]);
			attachChild(playerXpBar[0]);

		}

		// Create player two
		if (player[1] != null) {
			playerPortrait[1].setPosition(170, 50);
			attachChild(playerPortrait[1]);

			playerHealthBar[1] = new Rectangle(0, 0,
					player[1].getHealthPercentage(), 20,
					this.engine.getVertexBufferObjectManager());
			playerHealthBar[1].setColor(1.0f, 0, 0);

			playerResourceBar[1] = new Rectangle(0, 0,
					player[1].getResourcePercentage(), 20,
					this.engine.getVertexBufferObjectManager());
			if(player[1].getClass() == WarriorClass.class) {
				playerResourceBar[1].setColor(1.0f, 0.4f, 0.4f);
			} else if(player[1].getClass() == RangerClass.class) {
				playerResourceBar[1].setColor(1.0f, 1.0f, 0);
			} else if(player[1].getClass() == ClericClass.class) {
				playerResourceBar[1].setColor(0, 0, 1.0f);
			}
			
			playerXpBar[1] = new Rectangle(0, 0,
					player[1].getExperiencePercentage(), 20,
					this.engine.getVertexBufferObjectManager());
			playerXpBar[1].setColor(0, 1.0f, 1.0f);

			playerHealthBar[1].setPosition(230, 50);
			playerResourceBar[1].setPosition(230, 70);
			playerXpBar[1].setPosition(230, 90);

			attachChild(playerHealthBar[1]);
			attachChild(playerResourceBar[1]);
			attachChild(playerXpBar[1]);

		}

		// Create player three
		if (player[2] != null) {
			playerPortrait[2].setPosition(340, 50);
			attachChild(playerPortrait[2]);

			playerHealthBar[2] = new Rectangle(0, 0,
					player[2].getHealthPercentage(), 20,
					this.engine.getVertexBufferObjectManager());
			playerHealthBar[2].setColor(1.0f, 0, 0);

			playerResourceBar[2] = new Rectangle(0, 0,
					player[2].getResourcePercentage(), 20,
					this.engine.getVertexBufferObjectManager());
			if(player[2].getClass() == WarriorClass.class) {
				playerResourceBar[2].setColor(1.0f, 0.4f, 0.4f);
			} else if(player[2].getClass() == RangerClass.class) {
				playerResourceBar[2].setColor(1.0f, 1.0f, 0);
			} else if(player[2].getClass() == ClericClass.class) {
				playerResourceBar[2].setColor(0, 0, 1.0f);
			}

			playerXpBar[2] = new Rectangle(0, 0,
					player[2].getExperiencePercentage(), 20,
					this.engine.getVertexBufferObjectManager());
			playerXpBar[2].setColor(0, 1.0f, 1.0f);

			playerHealthBar[2].setPosition(400, 50);
			playerResourceBar[2].setPosition(400, 70);
			playerXpBar[2].setPosition(400, 90);

			attachChild(playerHealthBar[2]);
			attachChild(playerResourceBar[2]);
			attachChild(playerXpBar[2]);
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

	private void updateInventory() {
		// Name, level, str, dex, int, vit, dmg, armor
		if (player[0] != null && playerSelected == 0) {
			playerInfo[0]
					.setText(player[0].getName() + "\n" + "Level: "
							+ player[0].getLevel() + "\n" + "Str: "
							+ player[0].getCurrentStats().getStrength() + "\n"
							+ "Dex: "
							+ player[0].getCurrentStats().getDexterity() + "\n"
							+ "Int: "
							+ player[0].getCurrentStats().getIntelligence()
							+ "\n" + "Vit: "
							+ player[0].getCurrentStats().getVitality() + "\n"
							+ "Dmg: " + player[0].getCurrentStats().getDamage()
							+ "\n" + "Armor: "
							+ player[0].getCurrentStats().getArmor());

			playerInfo[0].setVisible(true);
			
			if(player[1] != null) {
				playerInfo[1].setVisible(false);
			}
			
			if(player[2] != null) {
				playerInfo[2].setVisible(false);
			}
			
			// TODO
			// Add warrior equipped items

		} else if (player[1] != null && playerSelected == 1) {
			playerInfo[1]
					.setText(player[1].getName() + "\n" + "Level: "
							+ player[1].getLevel() + "\n" + "Str: "
							+ player[1].getCurrentStats().getStrength() + "\n"
							+ "Dex: "
							+ player[1].getCurrentStats().getDexterity() + "\n"
							+ "Int: "
							+ player[1].getCurrentStats().getIntelligence()
							+ "\n" + "Vit: "
							+ player[1].getCurrentStats().getVitality() + "\n"
							+ "Dmg: " + player[1].getCurrentStats().getDamage()
							+ "\n" + "Armor: "
							+ player[1].getCurrentStats().getArmor());

			playerInfo[0].setVisible(false);
			playerInfo[1].setVisible(true);
			
			if(player[2] != null) {
				playerInfo[2].setVisible(false);
			}
			
			// TODO
			// Add ranger equipped items

		} else if (player[2] != null && playerSelected == 2) {
			playerInfo[2]
					.setText(player[2].getName() + "\n" + "Level: "
							+ player[2].getLevel() + "\n" + "Str: "
							+ player[2].getCurrentStats().getStrength() + "\n"
							+ "Dex: "
							+ player[2].getCurrentStats().getDexterity() + "\n"
							+ "Int: "
							+ player[2].getCurrentStats().getIntelligence()
							+ "\n" + "Vit: "
							+ player[2].getCurrentStats().getVitality() + "\n"
							+ "Dmg: " + player[2].getCurrentStats().getDamage()
							+ "\n" + "Armor: "
							+ player[2].getCurrentStats().getArmor());

			playerInfo[0].setVisible(false);
			playerInfo[1].setVisible(false);
			playerInfo[2].setVisible(true);
			
			// TODO
			// Add cleric equipped items
		}

	}

	private void createPlayerStatsArea() {
		if (player[0] != null) {
			playerInfo[0] = new Text(0, 0, resourcesManager.inventoryFont, "",
					150, new TextOptions(HorizontalAlign.LEFT), vbom);

			playerInfo[0].setPosition(10, 10);

			playerInfo[0].setVisible(false);
		}

		if (player[1] != null) {
			playerInfo[1] = new Text(0, 0, resourcesManager.inventoryFont, "",
					150, new TextOptions(HorizontalAlign.LEFT), vbom);

			playerInfo[1].setPosition(10, 10);

			playerInfo[1].setVisible(false);

		}

		if (player[2] != null) {
			playerInfo[2] = new Text(0, 0, resourcesManager.inventoryFont, "",
					150, new TextOptions(HorizontalAlign.LEFT), vbom);

			playerInfo[2].setPosition(10, 10);

			playerInfo[2].setVisible(false);
		}

	}

public void writeToScreen(final CharSequence pText) {
		
		activity.runOnUiThread(new Runnable() {
			public void run() {
					Toast.makeText(activity, pText, Toast.LENGTH_SHORT).show();
				
			}
		});
	}
}
