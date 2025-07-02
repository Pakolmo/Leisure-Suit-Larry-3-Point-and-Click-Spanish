;;; Sierra Script 1.0 - (do not remove this comment)
(script# 994)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use SysWindow)
(use Cycle)
(use InvI)
(use User)
(use Obj)


(procedure (localproc_0004 param1 &tmp temp0 [temp1 40] [temp41 40] [temp81 40])
	(= temp0 1)
	(DeviceInfo 0 global30 @temp1)
	(DeviceInfo 1 @temp41)
	(if
		(and
			(DeviceInfo 2 @temp1 @temp41)
			(DeviceInfo 3 @temp41)
		)
		(Format
			@temp81
			994
			6
			(if param1 {SAVE GAME} else {GAME})
			@temp41
		)
		(DeviceInfo 4)
		(= temp0
			(if param1
				(proc255_0
					@temp81
					33
					0
					81
					{OK}
					1
					81
					{Cancelar}
					0
					81
					{Cambiar Directorio}
					2
				)
			else
				(proc255_0 @temp81 33 0 81 {OK} 1)
			)
		)
		(if (== temp0 2) (= temp0 (proc990_0 global30)))
	)
	(return temp0)
)

(class Game of Obj
	(properties
		script 0
	)
	
	(method (play)
		(= gGame self)
		(= global30 (GetSaveDir))
		(if (not (GameIsRestarting)) (GetCWD global30))
		(self setCursor: global21 1)
		(self init:)
		(self setCursor: global20 (HaveMouse))
		(while (not global4)
			(self doit:)
			(= global18 (Wait gNewSpeed))
		)
	)
	
	(method (replay)
		(if global24 (global24 dispose:))
		(gSFeatures release:)
		(if gTheNewDialog (gTheNewDialog dispose:))
		(gCast eachElementDo: #perform RU)
		(gGame setCursor: global21 1)
		(DrawPic (global2 curPic?) 100 dpCLEAR global61)
		(if (!= gPicNumber -1)
			(DrawPic gPicNumber 100 dpNO_CLEAR global61)
		)
		(if (global2 controls?) ((global2 controls?) draw:))
		(gAddToPics doit:)
		(gGame setCursor: global20 (HaveMouse))
		(SL doit:)
		(DoSound sndRESUME)
		(Sound pause: 0)
		(while (not global4)
			(self doit:)
			(= global18 (Wait gNewSpeed))
		)
	)
	
	(method (init &tmp theMotion)
		(= theMotion Motion)
		(= theMotion Sound)
		(= theMotion Save)
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSFeatures sFeatures) add:)
		((= gSounds sounds) add:)
		((= gRegions regions) add:)
		((= gLocales locales) add:)
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
		(= global30 (GetSaveDir))
		(Inv init:)
		(User init:)
	)
	
	(method (doit)
		(gSounds eachElementDo: #check)
		(gTimers eachElementDo: #doit)
		(if gTheNewDialog (gTheNewDialog check:))
		(Animate (gCast elements?) 1)
		(if global58
			(= global58 0)
			(gCast eachElementDo: #motionCue)
		)
		(if script (script doit:))
		(gRegions eachElementDo: #doit)
		(if (== gNewRoomNumber gNumber) (User doit:))
		(if (!= gNewRoomNumber gNumber)
			(self newRoom: gNewRoomNumber)
		)
		(gTimers eachElementDo: #delete)
		(GameIsRestarting 0)
	)
	
	(method (showSelf)
		(gRegions showSelf:)
	)
	
	(method (newRoom newRoomNumber &tmp [temp0 4] temp4 temp5)
		(gAddToPics dispose:)
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose eachElementDo: #delete)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gLocales eachElementDo: #dispose release:)
		(Animate 0)
		(= gGNumber gNumber)
		(= gNumber newRoomNumber)
		(= gNewRoomNumber newRoomNumber)
		(FlushResources newRoomNumber)
		(= temp4 (self setCursor: global21 1))
		(self
			startRoom: gNumber
			checkAni:
			setCursor: temp4 (HaveMouse)
		)
		(SetSynonyms gRegions)
		(while ((= temp5 (Event new: 3)) type?)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)
	
	(method (checkAni &tmp temp0)
		(Animate (gCast elements?) 0)
		(Wait 0)
		(Animate (gCast elements?) 0)
		(while (> (Wait 0) global50)
			(= temp0 (gCast firstTrue: #isExtra))
			(if (== temp0 0) (break))
			(temp0 addToPic:)
			(Animate (gCast elements?) 0)
			(gCast eachElementDo: #delete)
		)
	)
	
	(method (startRoom param1)
		(if global14 (SetDebug))
		(gRegions addToFront: (= global2 (ScriptID param1)))
		(global2 init:)
		(if global55 (global2 setRegions: 975))
	)
	
	(method (handleEvent pEvent)
		(asm
			lag      global54
			bnt      code_03f4
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      128
			eq?     
			bnt      code_03f4
			ldi      1
code_03f4:
			not     
			bnt      code_0413
			pushi    #handleEvent
			pushi    1
			lsp      pEvent
			lag      gRegions
			send     6
			bt       code_040f
			pushi    #handleEvent
			pushi    1
			lsp      pEvent
			lag      gLocales
			send     6
			bnt      code_0413
code_040f:
			ldi      1
			bt       code_0423
code_0413:
			pToa     script
			bnt      code_0421
			pushi    #handleEvent
			pushi    1
			lsp      pEvent
			pToa     script
			send     6
code_0421:
			bnt      code_0425
code_0423:
			ldi      1
code_0425:
			pushi    #claimed
			pushi    0
			lap      pEvent
			send     4
			ret     
		)
	)
	
	(method (changeScore param1)
		(= global15 (+ global15 param1))
		(SL doit:)
	)
	
	(method (restart)
		(if gTheNewDialog (gTheNewDialog dispose:))
		(RestartGame)
	)
	
	(method (save &tmp [temp0 20] temp20 temp21 temp22)
		(Load rsFONT global23)
		(Load rsCURSOR global21)
		(gGame sel_333: global196)
		(= global27 global196)
		(= temp21 (self setCursor: global20))
		(= temp22 (Sound pause: 1))
		(if (localproc_0004 1)
			(if gTheNewDialog (gTheNewDialog dispose:))
			(= temp20 (Save doit: @temp0))
			(if (!= temp20 -1)
				(= temp21 (self setCursor: global21 1))
				(if (not (SaveGame name temp20 @temp0 global28))
					(proc255_0 994 0 33 0 81 {OK} 1)
				)
				(self setCursor: temp21 (HaveMouse))
			)
			(localproc_0004 0)
		)
		(Sound pause: temp22)
	)
	
	(method (restore &tmp [temp0 20] temp20 temp21 temp22)
		(Load rsFONT global23)
		(Load rsCURSOR global21)
		(= temp21 (self setCursor: global20))
		(= temp22 (Sound pause: 1))
		(if (localproc_0004 1)
			(if gTheNewDialog (gTheNewDialog dispose:))
			(= temp20 (Cargar_ doit: &rest))
			(if (!= temp20 -1)
				(self setCursor: global21 1)
				(if (CheckSaveGame name temp20 global28)
					(gCast eachElementDo: #dispose)
					(gCast eachElementDo: #delete)
					(RestoreGame name temp20 global28)
				else
					(proc255_0 994 1 33 0 81 {OK} 1)
					(self setCursor: temp21 (HaveMouse))
				)
			)
			(localproc_0004 0)
		)
		(gGame sel_333: global196)
		(DoSound sndVOLUME global196)
		(Sound sel_334: temp22)
	)
	
	(method (setSpeed newSpeed &tmp theGNewSpeed)
		(= theGNewSpeed gNewSpeed)
		(= gNewSpeed newSpeed)
		(return theGNewSpeed)
	)
	
	(method (sel_333 param1 &tmp temp0)
		(= temp0 global27)
		(= global27 param1)
		(return temp0)
	)
	
	(method (setCursor cursorNumber &tmp theGCursorNumber)
		(= theGCursorNumber gCursorNumber)
		(= gCursorNumber cursorNumber)
		(SetCursor cursorNumber &rest)
		(return theGCursorNumber)
	)
	
	(method (showMem)
		(proc255_4
			{Free Heap: %u Bytes\n Largest ptr: %u Bytes\n FreeHunk: %u KBytes\n Largest hunk: %u Bytes}
			(MemoryInfo 1)
			(MemoryInfo 0)
			(>> (MemoryInfo 3) $0006)
			(MemoryInfo 2)
		)
	)
	
	(method (wordFail param1 &tmp [temp0 100])
		(proc255_4 994 2 param1)
		(return 0)
	)
	
	(method (syntaxFail)
		(proc255_0 994 3)
	)
	
	(method (semanticFail)
		(proc255_0 994 4)
	)
	
	(method (pragmaFail)
		(proc255_0 994 5)
	)
	
	(method (notify)
	)
	
	(method (setScript theScript)
		(if script (script dispose:))
		(if theScript (theScript init: self &rest))
	)
	
	(method (cue)
		(if script (script cue:))
	)
)

(class Rgn of Obj
	(properties
		script 0
		number 0
		timer 0
		keep 0
		initialized 0
	)
	
	(method (init)
		(if (not initialized)
			(= initialized 1)
			(if (not (gRegions contains: self))
				(gRegions addToEnd: self)
			)
			(super init:)
		)
	)
	
	(method (doit)
		(if script (script doit:))
	)
	
	(method (handleEvent pEvent)
		(if script (script handleEvent: pEvent))
		(pEvent claimed?)
	)
	
	(method (dispose)
		(gRegions delete: self)
		(if (IsObject script) (script dispose:))
		(if (IsObject timer) (timer dispose:))
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)
	
	(method (setScript theScript)
		(if (IsObject script) (script dispose:))
		(if theScript (theScript init: self &rest))
	)
	
	(method (cue)
		(if script (script cue:))
	)
	
	(method (newRoom)
	)
	
	(method (notify)
	)
)

(class Rm of Rgn
	(properties
		script 0
		number 0
		timer 0
		keep 0
		initialized 0
		picture 0
		style $ffff
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY -30000
	)
	
	(method (init &tmp temp0)
		(= number gNumber)
		(= controls controls)
		(= gPicAngle picAngle)
		(if picture (self drawPic: picture))
		(switch ((User alterEgo?) edgeHit?)
			(1 ((User alterEgo?) y: 188))
			(4
				((User alterEgo?)
					x: (- 319 ((User alterEgo?) xStep?))
				)
			)
			(3
				((User alterEgo?)
					y: (+ horizon ((User alterEgo?) yStep?))
				)
			)
			(2 ((User alterEgo?) x: 1))
		)
		((User alterEgo?) edgeHit: 0)
	)
	
	(method (doit &tmp temp0)
		(gGame sel_333: global196)
		(DoSound sndVOLUME global196)
		(if script (script doit:))
		(= temp0
			(switch ((User alterEgo?) edgeHit?)
				(1 north)
				(2 east)
				(3 south)
				(4 west)
			)
		)
		(if temp0 (self newRoom: temp0))
	)
	
	(method (dispose)
		(if controls (controls dispose:))
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(asm
			pushi    #handleEvent
			pushi    1
			lsp      pEvent
			super    Rgn,  6
			bt       code_086e
			pToa     controls
			bnt      code_086c
			pushi    #handleEvent
			pushi    1
			lsp      pEvent
			pToa     controls
			send     6
code_086c:
			bnt      code_0870
code_086e:
			ldi      1
code_0870:
			pushi    #claimed
			pushi    0
			lap      pEvent
			send     4
			ret     
		)
	)
	
	(method (setRegions scriptNumbers &tmp temp0 theScriptNumbers temp2)
		(= temp0 0)
		(while (< temp0 argc)
			(= theScriptNumbers [scriptNumbers temp0])
			(= temp2 (ScriptID theScriptNumbers))
			(temp2 number: theScriptNumbers)
			(gRegions add: temp2)
			(if (not (temp2 initialized?)) (temp2 init:))
			(++ temp0)
		)
	)
	
	(method (setLocales scriptNumbers &tmp temp0 theScriptNumbers temp2)
		(= temp0 0)
		(while (< temp0 argc)
			(= theScriptNumbers [scriptNumbers temp0])
			((= temp2 (ScriptID theScriptNumbers))
				number: theScriptNumbers
			)
			(gLocales add: temp2)
			(temp2 init:)
			(++ temp0)
		)
	)
	
	(method (setFeatures theFeatures &tmp temp0 [temp1 2])
		(= temp0 0)
		(while (< temp0 argc)
			(gFeatures add: [theFeatures temp0])
			(++ temp0)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gRegions
			delete: self
			eachElementDo: #newRoom newRoomNumber
			addToFront: self
		)
		(= gNewRoomNumber newRoomNumber)
		(super newRoom: newRoomNumber)
	)
	
	(method (drawPic picNumber picAnimation)
		(addToPics dispose:)
		(= curPic picNumber)
		(= gPicNumber -1)
		(DrawPic
			picNumber
			(cond 
				((== argc 2) picAnimation)
				((!= style -1) style)
				(else global17)
			)
			dpCLEAR
			global61
		)
	)
	
	(method (overlay picNumber picAnimation)
		(= gPicNumber picNumber)
		(DrawPic
			picNumber
			(cond 
				((== argc 2) picAnimation)
				((!= style -1) style)
				(else global17)
			)
			dpNO_CLEAR
			global61
		)
	)
)

(class Locale of Obj
	(properties
		number 0
	)
	
	(method (handleEvent pEvent)
		(pEvent claimed?)
	)
	
	(method (dispose)
		(gLocales delete: self)
		(DisposeScript number)
	)
)

(class SL of Obj
	(properties
		state $0000
		code 0
	)
	
	(method (doit &tmp [temp0 41])
		(if code
			(code doit: @temp0)
			(DrawStatus (if state @temp0 else 0))
		)
	)
	
	(method (enable)
		(= state 1)
		(self doit:)
	)
	
	(method (disable)
		(= state 0)
		(self doit:)
	)
)

(instance cast of EventHandler
	(properties)
)

(instance features of EventHandler
	(properties)
)

(instance sFeatures of EventHandler
	(properties)
	
	(method (delete param1)
		(super delete: param1)
		(if
			(and
				global54
				(param1 isKindOf: Collect)
				(not (proc999_5 param1 gRegions gLocales))
			)
			(param1 release: dispose:)
		)
	)
)

(instance sounds of EventHandler
	(properties)
)

(instance regions of EventHandler
	(properties)
)

(instance locales of EventHandler
	(properties)
)

(instance addToPics of EventHandler
	(properties)
	
	(method (doit)
		(AddToPic elements)
	)
)

(instance controls of Controls
	(properties)
)

(instance timers of Set
	(properties)
)

(instance RU of Code
	(properties)
	
	(method (doit param1 &tmp temp0)
		(if (param1 underBits?)
			(= temp0 (param1 signal?))
			(= temp0 (| temp0 $0001))
			(= temp0 (& temp0 $fffb))
			(param1 underBits: 0 signal: temp0)
		)
	)
)

(instance DNKR of Code
	(properties)
	
	(method (doit param1)
		(if (not (param1 keep?)) (param1 dispose:))
	)
)
