;;; Sierra Script 1.0 - (do not remove this comment)
(script# 440)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm440 0
)

(local
	[local0 2]
)
(procedure (localproc_000c)
	(gTheWindow color: 12 back: 8)
	(proc255_0 &rest 67 20 -1 80 {Cherri dice} 70 150)
	(gTheWindow color: 0 back: 8)
)

(procedure (localproc_0042)
	(gTheWindow color: 9 back: 8)
	(proc255_0 &rest 67 180 -1 80 {Dices} 70 120)
	(gTheWindow color: 0 back: 8)
)

(instance rm440 of Rm
	(properties
		picture 440
		east 420
	)
	
	(method (init)
		(SL disable:)
		(TheMenuBar hide:)
		(Load rsVIEW 440)
		(Load rsVIEW 444)
		(super init:)
		(self setScript: RoomScript)
		(proc0_1 1)
		(gEgo
			viewer: shadowViewer
			posn: 315 151
			observeBlocks: theCage
			init:
		)
		(User canInput: 0 mapKeyToDir: 0)
		(cond 
			((not (proc0_22 35))
				(proc0_19 35)
				(proc0_19 5)
				(Load rsVIEW 443)
				(Load rsVIEW 442)
				(Load rsSOUND 8)
				(Load rsSOUND 10)
				(Load rsPIC 99)
				(proc0_3)
				(aCherri init: setCycle: Walk ignoreActors:)
				(RoomScript changeState: 1)
			)
			((== gGNumber_2 11)
				(Load rsVIEW 441)
				(Load rsVIEW 445)
				(aLclothes ignoreActors: init:)
			)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (changeState newState)
		(proc21_1 self newState 1 7)
		(switch (= state newState)
			(0)
			(1
				(gEgo setMotion: MoveTo 155 151 self)
				(aCherri setMotion: MoveTo 210 151 self)
			)
			(2
				(localproc_000c 440 12)
				(aCherri
					view: 442
					setLoop: 0
					setMotion: MoveTo 94 151 self
				)
			)
			(3 (localproc_0042 440 13))
			(4
				(aCherri setLoop: 1 cel: 0)
				(= seconds 3)
			)
			(5
				(localproc_000c 440 14)
				(gTheMusic number: 8 loop: -1 play:)
				(= seconds 3)
			)
			(6
				(aCherri cycleSpeed: 1 setCycle: End self)
			)
			(7
				(aCherri setLoop: 2 cel: 0)
				(aHat ignoreActors: init: stopUpd:)
				(= seconds 3)
			)
			(8 (aCherri setCycle: End self))
			(9
				(aCherri setLoop: 3 cel: 0)
				(aTail ignoreActors: init: stopUpd:)
				(= seconds 3)
			)
			(10
				(aCherri setCycle: End self)
			)
			(11
				(aBra ignoreActors: init: stopUpd:)
				(= seconds 3)
			)
			(12
				(aCherri
					setLoop: 5
					setCycle: Walk
					setMotion: MoveTo 114 151 self
				)
			)
			(13
				(localproc_000c 440 15)
				(= seconds 3)
			)
			(14
				(proc255_0 440 16)
				(proc255_0 440 17)
				(= gGNumber_2 1)
				(gEgo
					viewer: 0
					view: 442
					loop: 4
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(15
				(aLclothes ignoreActors: init: stopUpd:)
				(gEgo setLoop: 6 cel: 0 setCycle: Walk)
				(= seconds 2)
			)
			(16
				(aCherri loop: 7 cel: 0 setCycle: End)
				(gEgo setMotion: MoveTo 145 151 self)
			)
			(17
				(aCherri dispose:)
				(gEgo
					view: 443
					loop: 0
					cel: 0
					posn: 114 151
					setCycle: End self
				)
			)
			(18 (= seconds 3))
			(19
				(localproc_000c 440 18)
				(= seconds 3)
			)
			(20
				(if (< global88 1)
					(self changeState: 24)
				else
					(gEgo viewer: humpCycler loop: 1 cel: 0 setCycle: Fwd)
					(= seconds 3)
				)
			)
			(21
				(if (<= global88 2)
					(self changeState: 24)
				else
					(gEgo loop: 2)
					(= seconds 3)
				)
			)
			(22
				(if (<= global88 3)
					(self changeState: 24)
				else
					(gEgo loop: 3)
				)
				(= seconds 3)
			)
			(23
				(if (< global88 4)
					(self changeState: 24)
				else
					(gEgo loop: 4)
				)
				(= seconds 3)
			)
			(24
				(localproc_000c 440 19)
				(= seconds 3)
			)
			(25
				(localproc_0042 440 20)
				(= seconds 3)
			)
			(26
				(gTheMusic number: 10 loop: -1 play:)
				(global2 drawPic: 99 2)
				(gCast eachElementDo: #hide)
				(localproc_0042 440 21)
				(= cycles 11)
			)
			(27
				(localproc_0042 440 22)
				(= seconds 3)
			)
			(28
				(localproc_000c 440 23)
				(= seconds 3)
			)
			(29
				(proc255_0 440 24)
				(= seconds 3)
			)
			(30
				(localproc_0042 440 25)
				(= seconds 3)
			)
			(31
				(proc255_0 440 26 67 10 5 70 290)
				(= seconds 2)
			)
			(32
				(localproc_0042 440 27)
				(gTheWindow color: global105 back: global106)
				(global2 newRoom: 431)
			)
			(33
				(proc0_6)
				(proc0_3)
				(gEgo illegalBits: 0 setMotion: MoveTo 155 151 self)
			)
			(34
				(gEgo
					viewer: 0
					view: 445
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(35
				(aHat posn: 155 151 ignoreActors: init: stopUpd:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(36
				(aTail posn: 155 151 ignoreActors: init: stopUpd:)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(37
				(aBra posn: 155 151 ignoreActors: init: stopUpd:)
				(gEgo loop: 3 cel: 0 setCycle: End self)
				(= cycles 9)
			)
			(38 (aLclothes dispose:))
			(39
				(= global104 6)
				(= global98 3)
				(= gGNumber_2 18)
				(= global66 700)
				(proc0_1 1 444)
				(gEgo viewer: shadowViewer)
				(gGame changeScore: 25)
				(= cycles 22)
			)
			(40 (proc255_0 440 28))
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'smell') (proc255_0 440 0))
			(
				(or
					(Said 'naked')
					(Said
						'(alter<(out<of),from),(off<get),(get<off),drain/cloth,dress,cloth'
					)
					(Said 'dress<get')
					(Said 'get/dress')
					(Said
						'wear,get,(alter<in,to),(backdrop<on)//cloth,cloth[<leisure]'
					)
					(Said
						'wear,get,(alter<in,to),(backdrop<on)/cloth,cloth[<leisure]'
					)
				)
				(cond 
					((not (gEgo inRect: 121 127 199 159)) (proc0_10))
					((!= gGNumber_2 11) (proc255_0 440 1) (proc255_0 440 2) (proc255_0 440 3))
					(else (self changeState: 33))
				)
			)
			((Said 'look>')
				(cond 
					((Said '/burn,ceiling') (proc255_0 440 4))
					(
						(and
							(== gGNumber_2 11)
							(Said '/backstage,carpet')
							(proc255_0 440 5)
						)
					)
					((Said '/cloth,hat,bra,panties')
						(if (== gGNumber_2 11)
							(proc255_0 440 5)
						else
							(proc255_0 440 6)
							(proc255_0 440 7 67 -1 144)
						)
					)
					((Said '/prop,backdrop') (proc255_0 440 8))
					((Said '/bottle') (proc255_0 440 9))
					((Said '[/area,backstage]') (proc255_0 440 10) (proc255_0 440 11 67 -1 144))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if
					(and
						(> (pEvent x?) 140)
						(< (pEvent x?) 160)
						(> (pEvent y?) 144)
						(< (pEvent y?) 150)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(994
							(cond 
								((not (gEgo inRect: 121 127 199 159)) (proc0_10))
								((!= gGNumber_2 11) (proc255_0 440 1) (proc255_0 440 2) (proc255_0 440 3))
								(else (self changeState: 33))
							)
						)
						(998
							(if (== gGNumber_2 11)
								(proc255_0 440 5)
							else
								(proc255_0 440 6)
								(proc255_0 440 7 67 -1 144)
							)
						)
						(995
							(cond 
								((not (gEgo inRect: 121 127 199 159)) (proc0_10))
								((!= gGNumber_2 11) (proc255_0 440 1) (proc255_0 440 2) (proc255_0 440 3))
								(else (self changeState: 33))
							)
						)
					)
				)
				(if
					(and
						(> (pEvent x?) 300)
						(< (pEvent x?) 319)
						(> (pEvent y?) 157)
						(< (pEvent y?) 189)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(999
							(gEgo setMotion: MoveTo 321 174)
						)
						(else  (pEvent claimed: 0))
					)
				)
			)
		)
	)
)

(instance aCherri of Act
	(properties
		y 151
		x 290
		view 446
		illegalBits $0000
	)
)

(instance aHat of View
	(properties
		y 144
		x 63
		view 440
	)
)

(instance aTail of View
	(properties
		y 148
		x 93
		view 440
		cel 1
	)
)

(instance aBra of View
	(properties
		y 143
		x 83
		view 440
		cel 2
	)
)

(instance aLclothes of View
	(properties
		y 145
		x 150
		view 440
		cel 3
	)
)

(instance theCage of Cage
	(properties
		top 144
		left -15
		bottom 212
		right 335
	)
)

(instance shadowViewer of Code
	(properties)
	
	(method (doit)
		(gEgo
			view:
				(cond 
					((not (& (gEgo onControl: 1) $0200)) global66)
					((== gGNumber_2 11) 441)
					((!= gGNumber_2 1) 444)
					(else (proc255_0 440 29))
				)
		)
	)
)

(instance humpCycler of Code
	(properties)
	
	(method (doit)
		(if (not (Random 0 9))
			(gEgo cycleSpeed: (Random 0 5))
		)
	)
)
