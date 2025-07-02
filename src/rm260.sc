;;; Sierra Script 1.0 - (do not remove this comment)
(script# 260)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Feature)
(use Obj)

(public
	rm260 0
)
(synonyms
	(maller babe)
	(man man)
)

(local
	local0
	local1
	local2
	[local3 2]
	[local5 50]
	[local45 32]
)
(instance rm260 of Rm
	(properties
		picture 260
		horizon 66
		west 250
	)
	
	(method (init &tmp temp0)
		(super init:)
		(User canInput: 0 mapKeyToDir: 0)
		(self setScript: RoomScript)
		(if (and (proc0_22 23) (== global96 0))
			(= global96 1)
			(= global100 267)
		)
		(if
			(and
				(gEgo has: 3)
				(< global96 6)
				(== global66 707)
				(== gGNumber_2 10)
				(or
					(== ((gInv at: 3) view?) 22)
					(== ((gInv at: 3) view?) 34)
				)
			)
			(= global96 5)
		)
		(if (== gGNumber_2 1) (= global96 3) (= global100 264))
		(if (< gGNumber gNumber) (gEgo posn: 1 174 loop: 0))
		(proc0_1)
		(switch global96
			(0
				(Load rsVIEW 712)
				(aLizard init:)
			)
			(1 (gEgo observeControl: 16384))
			(2
				(aTawni setLoop: 2 setCel: 255)
				(TawniScript changeState: 8)
				(gEgo observeControl: 16384)
				(-- global96)
			)
			(3
				(Load rsVIEW (- 263 (* 5 (>= global88 3))))
				(Load rsVIEW 264)
				(Load rsSOUND 8)
				(Load rsSOUND 9)
				(Load rsSOUND 260)
				(Load rsSOUND 261)
				(aTawni
					illegalBits: 0
					ignoreActors:
					view: (- 263 (* 5 (>= global88 3)))
					loop: 0
					cel: 0
				)
				(gEgo
					illegalBits: 0
					ignoreActors:
					view: global66
					loop: 0
					posn: 132 165
					setMotion: MoveTo 138 165
				)
				(RoomScript changeState: 29)
			)
			(4
				(aTawni init:)
				(gEgo observeControl: 16384)
			)
			(5
				(Load rsVIEW 707)
				(Load rsVIEW 22)
				(Load rsVIEW 34)
				(proc0_3)
				(proc0_19 5)
				(= global100 707)
				(= gGNumber_2 10)
				(aTawni init:)
			)
			(6
				(= global100 -1)
				(aTowel init:)
			)
			(7
				(aTowel init: hide:)
				(= global100 -1)
			)
		)
		(if (and (not global108) (>= global96 6))
			(Load rsVIEW (+ 701 global118))
			(Load rsVIEW 261)
			(Load rsVIEW 709)
			(aLizard init:)
		)
		(if (!= global96 5) (gEgo init:))
		(if (and global96 (< global96 6))
			(aTowel init:)
			(aTawni init:)
			(if (== global96 3) (TawniScript changeState: 11))
		)
		(if
			(and
				global100
				global96
				(not global97)
				(!= global100 -1)
				(< global96 6)
			)
			(aVendor init:)
		)
		(if (and (not global97) (!= global96 3))
			(gTheMusic number: 260 loop: -1 play:)
		)
		(if
			(and
				(== gGNumber_2 14)
				(or (== gGNumber 266) (== gGNumber 265))
			)
			(= gGNumber_2 0)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0100)
			(if (not local1)
				(= local1 1)
				(proc255_4 260 0 global82)
			)
		else
			(= local1 0)
		)
		(if (and (!= gGNumber_2 0) (!= gGNumber_2 1003))
			(gEgo observeControl: 512)
		)
		(if
		(and (== (gEgo onControl:) 512) (== gGNumber_2 0))
			(self changeState: 5)
		)
	)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0)
			(5
				(= cycles (= seconds 0))
				(proc0_3)
				(= gGNumber_2 1003)
				(gEgo
					view: (if global108 812 else 712)
					illegalBits: -513
					cycleSpeed: 1
					moveSpeed: 1
					setStep: 2 2
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(6
				(gEgo setMotion: 0 setCycle: End self)
			)
			(7 (gEgo hide:) (= seconds 2))
			(8
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: (+ 4 (gEgo view?))
					register: (Format @local5 260 24 global82)
					next: (Format @local45 260 25)
				)
			)
			(9
				(proc0_3)
				(gEgo setMotion: MoveTo 126 155 self)
			)
			(10
				(gEgo view: 709 setLoop: 0 cel: 0 setCycle: End self)
			)
			(11
				(aTowel hide:)
				(gEgo get: 8 setCycle: Beg self)
				(= global96 7)
				(gGame changeScore: 2)
			)
			(12
				(if local0 (= local0 0) (self cue:) else (proc0_1))
			)
			(13
				(proc0_3)
				(gEgo illegalBits: 0 setMotion: MoveTo 151 170 self)
				(LizardScript changeState: 8)
			)
			(14
				(gEgo
					view: 261
					setLoop: 0
					cel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(15
				(aTowel view: 261 loop: 1 posn: 184 170 show: stopUpd:)
				(gEgo
					view: global66
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 184 170 self
				)
			)
			(16
				(gEgo
					cycleSpeed: 1
					view: (+ 701 global118)
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(17
				(gEgo view: 261 setLoop: 2 cel: 0 setCycle: End self)
				(LizardScript changeState: 9)
			)
			(18
				(= gGNumber_2 1005)
				(User canInput: 1)
				(= seconds 5)
			)
			(19
				(proc255_0 260 26)
				(= seconds 5)
			)
			(20
				(proc255_0 260 27)
				(= seconds 5)
			)
			(21
				(if (proc0_22 11)
					(proc255_0 260 28)
					(= seconds 4)
				else
					(proc0_19 11)
					(gGame changeScore: 30)
					(proc255_0 260 29)
					(= seconds 10)
				)
			)
			(22
				(proc255_0 260 30)
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 259
					register: (Format @local5 260 31)
					next: (Format @local45 260 32)
				)
			)
			(23
				(proc0_3)
				(proc0_6)
				(= seconds 0)
				(gEgo view: 261 setCycle: Beg self)
			)
			(24
				(gEgo
					view: (+ 701 global118)
					setLoop: 0
					setCel: 255
					setCycle: Beg self
				)
			)
			(25
				(gEgo
					cycleSpeed: 0
					view: global66
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 151 169 self
				)
			)
			(26
				(gEgo
					cycleSpeed: 1
					view: 709
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(27
				(aTowel hide:)
				(gEgo setCycle: Beg self)
			)
			(28 (proc0_1) (= gGNumber_2 0))
			(29
				(proc0_3)
				(proc0_19 5)
				(= seconds 0)
				(aTawni setScript: 0 setCycle: End self)
				(gTheMusic number: 8 loop: -1 play:)
			)
			(30
				(aTawni hide:)
				(gEgo
					posn: 153 165
					view: (- 263 (* 5 (>= global88 3)))
					loop: 1
					cel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(31
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(32
				(gEgo viewer: humpCycler setLoop: 3 setCycle: Fwd)
			)
			(33
				(proc255_0 260 33)
				(proc255_0 260 34)
				(proc255_0 260 35)
				(gTheMusic number: 9 loop: 1 play:)
				(gEgo
					viewer: 0
					cycleSpeed: 1
					loop: 4
					cel: 0
					setCycle: End self
				)
			)
			(34
				(proc255_0 260 36)
				(= seconds 3)
			)
			(35
				(proc255_0 260 37)
				(proc255_0 260 38)
				(= seconds 3)
			)
			(36
				(proc255_0 260 39)
				(proc255_0 260 40 67 -1 144)
				(= seconds 3)
			)
			(37
				(proc255_0 260 41)
				(proc255_0 260 42)
				(if (>= global88 3) (proc255_0 260 43))
				(proc255_0 260 44)
				(= seconds 3)
			)
			(38
				(proc255_0 260 45)
				(proc255_0 260 46)
				(gEgo get: 2)
				(= global98 1)
				(= global104 0)
				(gGame changeScore: 40)
				(= seconds 3)
			)
			(39
				(proc255_0 260 47)
				(proc255_0 260 48)
				(proc255_0 260 49)
				(VendorScript changeState: 10)
				(= seconds 3)
			)
			(40 (gEgo setCycle: Beg self))
			(41
				(proc255_0 260 50)
				(= seconds 3)
			)
			(42
				(proc255_0 260 51)
				(gTheMusic number: 8 loop: -1 play:)
				(gEgo viewer: humpCycler setLoop: 3 setCycle: Fwd)
				(= seconds 12)
			)
			(43
				(gTheMusic fade:)
				(gTheMusic number: 261 loop: -1 play:)
				(proc255_0 260 53 #at -1 10)
				(gEgo
					viewer: 0
					cycleSpeed: 0
					loop: 4
					cel: 0
					setCycle: End self
				)
			)
			(44
				(aTawni view: 262 loop: 2 setCel: 255 show:)
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(45
				(proc255_0 260 54 #at -1 10)
				(gEgo
					posn: 142 165
					setLoop: 6
					setCycle: Fwd
					setStep: 1 1
					setMotion: MoveTo 127 165
				)
				(= cycles 44)
			)
			(46
;;;				(proc255_0 (Format @local5 260 52 global170) 67 -1 10)
				(proc255_0 (Format @local5 260 55 global170) #at -1 10)
				(gEgo cycleSpeed: 1 loop: 7 cel: 0 setCycle: End self)
			)
			(47
				(proc255_0 260 56 67 -1 10)
				(gEgo viewer: humpCycler loop: 8 setCycle: Fwd)
				(= seconds 3)
			)
			(48
				(proc255_0 260 57 67 -1 10)
				(= cycles 11)
			)
			(49
				(aTawni view: 262 setScript: TawniScript)
				(TawniScript changeState: 9)
				(gEgo viewer: 0 loop: 9 cel: 0 setCycle: End self)
			)
			(50
				(proc255_0 260 58 67 -1 10)
				(= seconds 3)
			)
			(51
				(gTheMusic number: 9 loop: 1 play: self)
				(proc255_0 260 59)
				(proc0_1 2)
				(proc0_20 5)
				(gEgo observeControl: 16384)
				(= global96 4)
				(= gGNumber_2 0)
			)
			(52
				(gTheMusic number: 260 loop: -1 play:)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(not (super handleEvent: pEvent))
				(not (pEvent claimed?))
				gTheNewDialog
				(== (pEvent message?) KEY_RETURN)
				(== (pEvent type?) evKEYBOARD)
				(== (pEvent type?) evMOUSEBUTTON)
			)
			(pEvent claimed: 1)
			(proc0_5)
			(self cue:)
		)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'carve,carve') (proc255_0 260 1))
			((Said 'get/crab') (proc255_0 260 2))
			(
				(or
					(Said '(get<on),throw,use,lie,bang/towel')
					(Said '(bath<air),sunbath')
					(Said 'get/tan,booth')
					(Said '/(bath<air),sunbath')
					(Said 'drain/cloth')
					(Said 'lie,bang/down[<on]/towel')
				)
				(cond 
					((== gGNumber_2 1005) (proc0_8))
					((== gGNumber_2 10) (proc255_0 260 3))
					((!= gGNumber_2 0) (proc0_9))
					((== global96 1) (proc255_0 260 4))
					((== global96 4) (proc255_0 260 5) (proc255_0 260 6))
					((== global96 6) (proc0_6) (= local0 1) (self changeState: 9))
					((not (gEgo has: 8)) (proc0_12))
					(else (proc0_6) (self changeState: 13))
				)
			)
			(
				(or
					(Said 'nightstand,(nightstand<up),(get<off),(get<up)')
					(Said 'sunbath<cease')
					(Said 'exit/towel')
				)
				(if (!= gGNumber_2 1005)
					(proc255_0 260 7)
				else
					(self changeState: 23)
				)
			)
			((Said '/towel>')
				(cond 
					((gEgo has: 8) (pEvent claimed: 0))
					(
						(or
							(& (aTowel signal?) $0080)
							(not (gCast contains: aTowel))
						)
						(proc255_0 260 8)
						(proc255_0 260 9)
						(pEvent claimed: 1)
					)
					((Said 'get,grab,rob,(pick<up)')
						(cond 
							((== gGNumber_2 10) (proc255_0 260 3))
							((!= gGNumber_2 0) (proc0_9))
							((== global96 1) (proc255_0 260 10))
							((== global96 4) (proc255_0 260 11) (proc255_0 260 6))
							((!= global96 6) (proc255_0 260 7))
							(else (proc0_6) (self changeState: 9))
						)
					)
					((Said 'look')
						(cond 
							((and (>= global96 1) (<= global96 5)) (proc255_0 260 12))
							((< global96 6) (proc255_0 260 13))
							((== global96 6) (proc255_0 260 14))
							((== gGNumber_2 1005) (proc255_0 260 15))
							(else (pEvent claimed: 0))
						)
					)
					(else (pEvent claimed: 0))
				)
			)
			((Said 'look>')
				(cond 
					((Said '/boulder,boulder') (proc255_0 260 16))
					((Said '/bay,water,bay') (proc255_0 260 17) (proc255_0 260 18))
					(
					(or (Said 'down<look') (Said '/beach,down,beach')) (proc255_0 260 19))
					((Said '/crab') (proc255_0 260 20))
					((Said '[/area]')
						(if (and global96 (< global96 5))
							(proc255_0 260 21)
						else
							(proc255_0 260 22)
						)
						(proc255_0 260 23)
					)
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(== (pEvent type?) evMOUSEBUTTON)
						(== gGNumber_2 1005)
						(== gCursorNumber 992)
					)
					(self changeState: 23)
				)
				(if
					(and
						(> (pEvent x?) 35)
						(< (pEvent x?) 140)
						(> (pEvent y?) 129)
						(< (pEvent y?) 172)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(8
							(cond 
								((== gGNumber_2 1005) (proc0_8))
								((== gGNumber_2 10) (proc255_0 260 3))
								((!= gGNumber_2 0) (proc0_9))
								((== global96 1) (proc255_0 260 4))
								((== global96 4) (proc255_0 260 5) (proc255_0 260 6))
								((== global96 6) (proc0_6) (= local0 1) (self changeState: 9))
								((not (gEgo has: 8)) (proc0_12))
								(else (proc0_6) (self changeState: 13))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(proc0_26 aTawni (pEvent x?) (pEvent y?))
						(gCast contains: aTawni)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(cond 
								((== 707 (gEgo view?)) (proc255_0 260 77))
								((== global96 4) (proc255_0 260 78))
								((== local2 1) (proc255_0 260 79))
								((not (& (gEgo onControl:) $1000)) (proc0_10))
								(else
									(if (not (proc0_22 61)) (proc255_4 260 80 global171))
									(proc0_3)
									(gGame setCursor: 998)
									(= global96 2)
									(TawniScript changeState: 5)
								)
							)
						)
						(996
							(cond 
								((not (& (gEgo onControl:) $1000)) (proc0_10))
								((== 707 (gEgo view?)) (proc255_0 260 69) (proc255_0 260 75))
								((== global96 4)
									(proc255_0 260 69)
									(proc255_0 260 70)
									(proc255_0 260 71 67 -1 144)
								)
								(else (proc255_0 260 76))
							)
						)
						(3
							(proc255_0 260 62)
							(proc255_0 260 63)
						)
						(5
							(proc255_0 260 64)
							(proc255_0 260 64)
							(proc255_0 260 65)
						)
						(11 (proc255_0 260 66))
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 aTowel (pEvent x?) (pEvent y?))
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998)
						(995
							(cond 
								((== gGNumber_2 1005) (proc0_8))
								((== gGNumber_2 10) (proc255_0 260 3))
								((!= gGNumber_2 0) (proc0_9))
								((== global96 1) (proc255_0 260 4))
								((== global96 4) (proc255_0 260 5) (proc255_0 260 6))
								((== global96 6) (proc0_6) (= local0 1) (self changeState: 9))
								((not (gEgo has: 8)))
								(else (proc0_6) (self changeState: 13))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 0)
						(< (pEvent x?) 10)
						(> (pEvent y?) 122)
						(< (pEvent y?) 167)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo -4 148 self)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if
					(and
						(> (pEvent x?) 5)
						(< (pEvent x?) 319)
						(> (pEvent y?) 15)
						(< (pEvent y?) 134)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(998
							(if (and global96 (< global96 5))
								(proc255_0 260 21)
							else
								(proc255_0 260 22)
							)
							(proc255_0 260 23)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aTawni of Act
	(properties
		y 165
		x 153
		view 262
		loop 1
	)
	
	(method (init)
		(super init:)
		(self setScript: TawniScript ignoreActors:)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'give,sell,show>')
				(cond 
					((not (& (gEgo onControl:) $1000)) (proc0_10))
					((== 707 (gEgo view?))
						(= temp0 (gInv indexOf: gGCursorNumber))
						(pEvent claimed: 0)
						(cond 
							((Said '[/!*]') (proc255_0 260 60))
							((not temp0) (proc255_0 260 61))
							((not (temp0 ownedBy: gEgo)) (proc0_12))
							((== temp0 (gInv at: 3)) (proc255_0 260 62) (proc255_0 260 63))
							((== temp0 (gInv at: 5)) (proc255_0 260 64) (proc255_0 260 64) (proc255_0 260 65))
							((== temp0 (gInv at: 11)) (proc255_0 260 66))
							(else (proc255_0 260 67))
						)
						(proc255_0 260 68)
					)
					((== global96 4)
						(proc255_0 260 69)
						(proc255_0 260 70)
						(proc255_0 260 71 67 -1 144)
					)
					(else (proc255_0 260 72))
				)
				(pEvent claimed: 1)
			)
			((or (Said '//maller>') (Said '/maller>'))
				(cond 
					((> global96 4) (pEvent claimed: 1) (proc255_0 260 73))
					((Said 'bang') (proc255_0 260 74))
					((Said 'address')
						(cond 
							((not (& (gEgo onControl:) $1000)) (proc0_10))
							((== 707 (gEgo view?)) (proc255_0 260 69) (proc255_0 260 75))
							((== global96 4)
								(proc255_0 260 69)
								(proc255_0 260 70)
								(proc255_0 260 71 67 -1 144)
							)
							(else (proc255_0 260 76))
						)
					)
					((Said 'look')
						(cond 
							((== 707 (gEgo view?)) (proc255_0 260 77))
							((== global96 4) (proc255_0 260 78))
							((== local2 1) (proc255_0 260 79))
							((not (& (gEgo onControl:) $1000)) (proc0_10))
							(else
								(if (not (proc0_22 61)) (proc255_4 260 80 global171))
								(proc0_3)
								(proc0_19 5)
								(= global96 2)
								(TawniScript changeState: 5)
							)
						)
					)
				)
			)
		)
	)
)

(instance TawniScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 7)))
			(1
				(aTawni cycleSpeed: 1 setLoop: 1 setCycle: End)
				(= seconds (Random 1 3))
			)
			(2
				(aTawni setCycle: Beg)
				(= seconds (Random 3 5))
			)
			(3
				(aTawni setLoop: (Random 4 5) setCycle: End)
				(= seconds (Random 3 5))
			)
			(4
				(aTawni setCycle: Beg self)
				(= state -1)
			)
			(5
				(= seconds 0)
				(aTawni
					cycleSpeed: 2
					setLoop: 2
					cel: 0
					setCycle: End self
				)
				(if (>= global88 3) (++ state))
			)
			(6
				(aTawni setLoop: 3 cel: 0 setCycle: End self)
			)
			(7
				(if (== global96 2)
					(if (not (proc0_22 61))
						(proc0_19 61)
						(proc255_0 260 81)
					)
					(= gGNumber_2 14)
					(global2 newRoom: 266)
				)
			)
			(8
				(= seconds 0)
				(if (>= global88 3)
					(self cue:)
				else
					(aTawni setCycle: Beg self)
				)
			)
			(9
				(aTawni setLoop: 2 setCel: 255 setCycle: Beg self)
				(= local2 0)
				(= state 0)
			)
			(11 (= seconds 0))
		)
	)
)

(instance aVendor of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: global100
			setCycle: Walk
			setScript: VendorScript
		)
	)
)

(instance VendorScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(aVendor posn: -15 123)
				(switch global100
					(707 (self cue:))
					(264
						(if (<= global88 1) (= cycles 99) else (= cycles 222))
					)
					(else 
						(= seconds (Random 5 11))
					)
				)
			)
			(1
				(= local2 1)
				(aVendor
					setLoop: 0
					view: global100
					setMotion: MoveTo 137 149 self
				)
				(= cycles 11)
			)
			(2
				(proc255_0 260 85)
				(= cycles 11)
			)
			(3
				(proc255_0 260 85)
				(= cycles 11)
			)
			(4 (proc255_0 260 86))
			(5
				(if
				(and (!= global96 3) (>= (TawniScript state?) 5))
					(return)
				)
				(proc255_0 260 87)
				(aVendor setLoop: (- (NumLoops aVendor) 1))
				(if (== global100 264)
					(aVendor setCycle: Fwd)
					(RoomScript changeState: 33)
					(return)
				)
				(aVendor viewer: salesViewer)
				(proc255_0 260 88)
				(switch global100
					(267 (proc255_0 260 89))
					(268 (proc255_0 260 90))
					(269 (proc255_0 260 91))
					(707 (proc255_0 260 92))
				)
				(TawniScript changeState: 5)
				(= cycles 30)
			)
			(6
				(switch global100
					(267 (proc255_0 260 93))
					(268
						(proc255_0 260 94)
						(proc255_0 260 95)
					)
					(269 (proc255_0 260 96))
					(707
						(proc255_0 260 97)
						(proc255_0 260 98 67 -1 144)
					)
				)
				(= cycles 30)
			)
			(7
				(switch global100
					(267 (proc255_0 260 99))
					(268 (proc255_0 260 100))
					(269 (proc255_0 260 101))
					(707
						(if (== ((Inv at: 3) view?) 22)
							(proc255_0 260 102 82 22 0 0)
						else
							(proc255_0 260 103 82 34 0 0)
						)
					)
				)
				(= cycles 30)
			)
			(8
				(switch global100
					(267 (proc255_0 260 104))
					(268 (proc255_0 260 105))
					(269
						(proc255_0 260 106)
						(proc255_0 260 107 67 -1 144)
					)
					(707
						(proc255_4 260 108 global170)
					)
				)
				(= cycles 30)
			)
			(9
				(aVendor loop: 0 setCycle: Walk viewer: 0)
				(switch global100
					(267
						(proc255_0 260 109)
						(proc255_0 260 110)
						(proc255_0 260 111)
					)
					(268 (proc255_0 260 112))
					(269
						(proc255_0 260 113)
						(proc255_0 260 114)
					)
					(707
						(proc255_0 260 115)
						(gGame changeScore: 35)
						(gEgo get: 6 put: 3 -1)
						(= global94 20)
						(proc255_0 260 116)
					)
				)
				(TawniScript cue:)
				(= cycles 30)
			)
			(10
				(aVendor
					cycleSpeed: 0
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -30 (Random 114 163) self
				)
			)
			(11
				(cond 
					((== global100 707) (= global100 -1) (= global96 6) (global2 newRoom: 250))
					((or (== global100 269) (== global100 264)) (= global100 -1))
					(else (++ global100) (self changeState: 0))
				)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look/man,man')
				(if (or (< state 1) (> state 10))
					(proc255_0 260 73)
				else
					(proc255_0 260 82)
				)
			)
			((Said 'address/man,man')
				(if (or (< state 1) (> state 10))
					(proc255_0 260 73)
				else
					(proc255_0 260 83)
					(proc255_0 260 84)
				)
			)
		)
	)
)

(instance aTowel of View
	(properties
		y 169
		x 154
		view 262
	)
	
	(method (init)
		(super init:)
		(self setPri: 4 ignoreActors: stopUpd:)
	)
)

(instance aLizard of Act
	(properties
		view 260
		priority 15
		illegalBits $0000
	)
	
	(method (init)
		(super init:)
		(self
			setCycle: Walk
			setScript: LizardScript
			setPri: 15
			ignoreActors:
		)
	)
)

(instance LizardScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== state 5)
				(>= (RoomScript state?) 23)
				(<= (RoomScript state?) 28)
			)
			(self cue:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (Random 0 1)
					(aLizard setLoop: 0 posn: -20 (Random 172 188))
				else
					(aLizard setLoop: 1 posn: 218 198)
				)
				(= seconds (Random 10 20))
			)
			(1
				(aLizard
					setMotion: MoveTo (Random 126 192) (Random 172 188) self
				)
			)
			(2 (= seconds (Random 2 5)))
			(3
				(aLizard
					cycleSpeed: 1
					setLoop: (+ 2 (aLizard loop?))
					cel: 0
					setCycle: End self
				)
			)
			(4 (= cycles (Random 3 7)))
			(5
				(aLizard
					setLoop: (+ 2 (aLizard loop?))
					cel: 0
					setCycle: Fwd
				)
				(if
					(and
						(<= (RoomScript state?) 22)
						(>= (RoomScript state?) 18)
					)
					(= seconds 7)
				else
					(= cycles (Random 5 9))
				)
			)
			(6
				(aLizard
					setLoop: (- (aLizard loop?) 2)
					setCel: 255
					setCycle: Beg self
				)
			)
			(7
				(aLizard
					setLoop: (- (aLizard loop?) 2)
					cycleSpeed: 0
					setCycle: Walk
				)
				(if (== 0 (aLizard loop?))
					(aLizard setMotion: MoveTo 218 198 self)
				else
					(aLizard setMotion: MoveTo -55 (Random 172 188) self)
				)
				(= state -1)
			)
			(8
				(= seconds (= cycles 0))
				(aLizard
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo (- (aLizard x?) 33) 222
				)
			)
			(9
				(if (>= global88 3)
					(aLizard
						setLoop: 0
						posn: -20 180
						setCycle: Walk
						setMotion: MoveTo 148 188 self
					)
				)
			)
			(10
				(aLizard setMotion: MoveTo 192 167 self)
			)
			(11
				(aLizard
					cycleSpeed: 1
					setLoop: 2
					cel: 0
					setCycle: End self
				)
				(= state 3)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(if (and state (Said '/lizard>'))
			(cond 
				((Said 'get,grab/') (proc255_0 260 117))
				((Said 'look/')
					(cond 
						((== state 0) (proc255_0 260 73))
						((and (== state 5) (== gGNumber_2 1005)) (proc255_0 260 118))
						(else (proc255_0 260 119))
					)
				)
				(else (proc255_0 260 120) (pEvent claimed: 1))
			)
		)
	)
)

(instance humpCycler of Code
	(properties)
	
	(method (doit)
		(cond 
			((<= global88 1) (gEgo setCycle: 0))
			((not (Random 0 9)) (gEgo cycleSpeed: (Random 0 5)))
		)
	)
)

(instance salesViewer of Code
	(properties)
	
	(method (doit)
		(if (not (Random 0 3))
			(aVendor setCel: (Random 0 (- (NumCels aVendor) 1)))
		)
	)
)
