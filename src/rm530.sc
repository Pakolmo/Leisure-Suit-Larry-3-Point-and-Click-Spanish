;;; Sierra Script 1.0 - (do not remove this comment)
(script# 530)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Jump)
(use Cycle)
(use Game)
(use InvI)
(use User)
(use Feature)
(use Obj)

(public
	rm530 0
	RoomScript 1
)
(synonyms
	(palm bureau)
	(blade dope)
)

(local
	local0
	local1
	local2
	local3
	[local4 44]
	[local48 23]
	local71
)
(instance rm530 of Rm
	(properties
		picture 530
		horizon 1
	)
	
	(method (init)
		(Load rsVIEW 813)
		(Load rsSOUND 4)
		(Load rsSCRIPT 991)
		(proc0_5)
		(super init:)
		(self setScript: RoomScript)
		(aRope init:)
		(User canInput: 0 mapKeyToDir: 0)
		(if (!= gGNumber 525)
			(gTheMusic number: 599 loop: global72 play:)
		)
		(cond 
			((== gGNumber 535)
				(= global108 1)
				(= local1 1)
				(= local3 531)
				(= global66 802)
				(proc0_1 2)
				(gEgo setStep: 2 1 posn: 215 75 init:)
				(aRope posn: 227 72 setCycle: End RopeScript)
			)
			((== gGNumber 540)
				(= global108 1)
				(= local1 1)
				(= local3 531)
				(= global66 802)
				(proc0_1 2)
				(gEgo setStep: 2 1 posn: 31 78 init:)
				(aRope posn: 227 72 setCel: 255 stopUpd:)
			)
			(else
				(= global108 1)
				(= global66 800)
				(Load rsVIEW 531)
				(Load rsVIEW 532)
				(Load rsVIEW 533)
				(Load rsVIEW 534)
				(Load rsVIEW 804)
				(Load rsVIEW 20)
				(Load rsVIEW 27)
				(Load rsSOUND 531)
				(Load rsSOUND 530)
				(Load rsSOUND 12)
				(Load rsSOUND 599)
				(gTheMusic number: 4 loop: 1 play:)
				(= gGNumber_2 530)
				(gEgo
					ignoreActors:
					ignoreHorizon:
					view: 804
					setLoop: 0
					setCycle: Fwd
					setStep: 1 8
					setPri: 12
					illegalBits: 0
					posn: 170 -99
					init:
				)
				(RoomScript changeState: 1)
			)
		)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(cond 
			(
				(and
					(== (gEgo view?) 534)
					(== (gEgo loop?) 1)
					(== (gEgo cel?) 1)
				)
				(gTheSoundFX number: 530 loop: 1 play:)
			)
			(
			(and (& (gEgo onControl:) $0002) (== gGNumber_2 0))
				(= gGNumber_2 2)
				(gEgo posn: (- (gEgo x?) 25) (gEgo y?))
				(self changeState: 65)
			)
			(
			(and (& (gEgo onControl:) $0080) (== gGNumber_2 0))
				(= gGNumber_2 2)
				(gEgo posn: (+ (gEgo x?) 25) (gEgo y?))
				(self changeState: 65)
			)
			(
			(and (& (gEgo onControl:) $0040) (== gGNumber_2 0))
				(= gGNumber_2 2)
				(gEgo posn: (gEgo x?) (+ (gEgo y?) 5))
				(self changeState: 65)
			)
			((& (gEgo onControl:) $0400) (global2 newRoom: 540))
			(
				(and
					(== local3 3)
					(or (!= 142 (gEgo x?)) (!= 128 (gEgo y?)))
				)
				(= local3 531)
				(self changeState: 58)
			)
			(
				(and
					(== gGNumber_2 0)
					(not (proc0_22 6))
					(not local1)
				)
				(cond 
					((== global71 30) (++ global71) (proc255_0 530 0))
					((== global71 60) (++ global71) (proc255_0 530 1))
					((or (> global71 90) (== local3 4)) (self changeState: 12))
				)
			)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_3))
			(1
				(gEgo
					ignoreActors:
					setStep: 1 1
					setMotion: JumpTo 170 155 self
				)
			)
			(2
				(gEgo setLoop: 1 setCel: 0)
				(gTheMusic number: 12 loop: 1 play:)
				(ShakeScreen 3 1)
				(= seconds 4)
			)
			(3
				(proc255_0 530 64)
				(= seconds 4)
			)
			(4
				(proc255_0 530 65)
				(= seconds 4)
			)
			(5
				(gEgo setCycle: End self)
				(gAddToPics add: atpTits doit:)
			)
			(6
				(gTheMusic number: 599 loop: global72 play:)
				(gEgo posn: 170 155 cel: 1)
				(proc0_1 2)
				(= gGNumber_2 0)
				(gGame setSpeed: global101)
			)
			(7
				(if (not (proc0_22 58))
					(proc0_19 58)
					(gGame changeScore: 10)
				)
				(proc0_6)
				(proc255_0 530 66)
				(proc0_3)
				(= local2 0)
				(gEgo
					view: 531
					cycleSpeed: 1
					setStep: 2 1
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(8
				(gEgo
					cycleSpeed: 0
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (Random 111 195) (gEgo y?) self
				)
			)
			(9
				(= cycles 11)
				(if (> 4 (++ local2)) (= state 7))
			)
			(10
				(gEgo
					cycleSpeed: 1
					setLoop: 0
					setCel: 255
					setCycle: Beg self
				)
			)
			(11
				(proc0_1)
				(= local3 1)
				(gEgo loop: 2 get: 20)
				(proc255_0 530 67)
			)
			(12
				(proc0_3)
				(= gGNumber_2 1001)
				(proc255_0 530 68)
				(gEgo loop: 2)
				(gTheMusic fade:)
				(= seconds 3)
			)
			(13
				(gEgo view: 804 loop: 1 setCel: 255 setCycle: Beg self)
			)
			(14
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 537
					register: (Format @local4 530 69)
					next: (Format @local48 530 70)
				)
			)
			(15
				(proc0_6)
				(proc0_3)
				(gEgo setMotion: MoveTo 151 142 self)
				(gTheMusic fade:)
			)
			(16
				(gEgo view: 531 loop: 8 cel: 0 setCycle: End self)
				(= seconds 3)
			)
			(17
				(gGame changeScore: -50)
				(if (== gGNumber_2 535)
					(proc255_0 530 71 67 -1 10 82 20 0 0)
					(= state 24)
				else
					(proc255_0 530 72 67 -1 10 82 20 0 0)
				)
				(= seconds 3)
			)
			(18
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(19
				(proc255_0 530 73 88 67 -1 10)
				(= local2 0)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(20
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(21
				(if (> 3 (++ local2)) (= state 19))
				(= cycles 20)
			)
			(22
				(gEgo loop: 5 cel: 0 setCycle: Fwd)
				(= cycles (* 3 (NumCels gEgo)))
			)
			(23
				(gEgo loop: 6 cel: 0 setCycle: End self)
			)
			(24
				(gEgo loop: 7 cel: 0 setCycle: End)
				(= cycles 44)
			)
			(25
				(proc255_0 530 74 88 67 -1 10)
				(gTheMusic number: 531 loop: -1 play:)
				(= seconds 3)
			)
			(26
				(gGame setSpeed: 6)
				(gEgo
					view: 533
					posn: (gEgo x?) (- (gEgo y?) 26)
					cycleSpeed: 1
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(27
				(gEgo
					put: 20 -1
					setLoop: 1
					cel: 0
					illegalBits: 0
					ignoreActors:
					setPri:
					setStep: 1 1
					setCycle: Fwd
					setMotion: MoveTo 232 91 self
				)
				(= cycles 11)
			)
			(28
				(proc255_0 530 75 88 67 -1 10)
				(= cycles 11)
			)
			(29
				(proc255_0 530 76 88 67 -1 10)
			)
			(30
				(proc255_0 530 77 88 67 -1 10)
				(gEgo setPri: 2 setMotion: MoveTo 49 91 self)
				(= cycles 22)
			)
			(31
				(proc255_0 530 78 88 67 -1 10)
				(= cycles 22)
			)
			(32
				(proc255_0 530 79 88 67 -1 144)
			)
			(33
				(gTheMusic fade:)
				(proc255_0 530 80 88 67 -1 10)
				(= seconds 3)
			)
			(34
				(= seconds (= cycles 0))
				(proc255_0 (Format @local4 530 81 global170) 88 67 -1 10)
				(gTheMusic number: 4 loop: 1 play:)
				(gEgo setLoop: 2 cel: 0 cycleSpeed: 0 setCycle: End self)
				(= state 65)
			)
			(35
				(proc0_6)
				(proc0_3)
				(proc255_0 530 82)
				(if (>= global88 3) (proc255_0 530 83 67 -1 144))
				(= gGNumber_2 533)
				(gEgo
					view: 532
					setLoop: 0
					illegalBits: 0
					posn: 129 116
					setPri: 11
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 128 47 self
				)
			)
			(36
				(= gGNumber_2 536)
				(User canInput: 1)
			)
			(37
				(proc0_6)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(38
				(gEgo setLoop: 0 cel: 0 setCycle: End self)
			)
			(39
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(40
				(gEgo get: 19 setLoop: 0 cel: 0 setCycle: End self)
			)
			(41
				(gGame changeScore: 25)
				(proc255_0 530 84)
				(if (>= global88 3) (proc255_0 530 85 67 -1 144))
				(User canInput: 1)
			)
			(42
				(proc0_6)
				(proc0_3)
				(gEgo
					cycleSpeed: 1
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 129 116 self
				)
			)
			(43
				(gEgo posn: 128 132)
				(proc0_1 3)
				(= gGNumber_2 0)
			)
			(44
				(proc0_6)
				(proc0_3)
				((Inv at: 20) view: 27)
				(Format ((Inv at: 20) name?) 530 86)
				(gGame changeScore: 100)
				(proc255_0 530 87 67 -1 10 82 20 0 0)
				(= seconds 3)
			)
			(45
				(proc255_0 530 88)
				(= local3 2)
				(proc0_1)
			)
			(46
				(proc0_3)
				(proc0_6)
				(= gGNumber_2 531)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 141 129 self
				)
			)
			(47
				(gTheMusic stop:)
				(gEgo
					view: 534
					posn: 142 128
					setLoop: 1
					cel: 0
					setCycle: Fwd
				)
				(= cycles (* 3 (- (NumCels gEgo) 1)))
			)
			(48
				(gEgo setLoop: 0 cel: 0 setCycle: End self)
			)
			(49
				(if (> 2 (++ local0)) (= state 46))
				(= seconds 3)
			)
			(50
				(proc255_0 530 89 67 -1 10)
				(gEgo setLoop: 1 setCycle: Fwd)
				(= cycles (* 3 (- (NumCels gEgo) 1)))
			)
			(51
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(52
				(gGame changeScore: 20)
				(proc255_0 530 90 67 10 5 70 290)
				(= local3 3)
				(gTheSoundFX stop:)
				(gTheMusic play:)
				(proc0_4)
			)
			(53
				(= local3 4)
				(gGame changeScore: 20)
				(proc0_6)
				(proc0_3)
				(gEgo
					view: 534
					posn: 141 129
					setPri: 9
					setLoop: 3
					setCycle: Fwd
				)
				(aRope
					view: 530
					setLoop: 0
					cel: 0
					posn: 227 72
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(54
				(aRope stopUpd:)
				(= cycles 10)
			)
			(55
				(proc255_0 530 91 67 10 5 70 290)
				(proc0_1 1)
				(gEgo put: 20 -1)
				(= gGNumber_2 0)
			)
			(56
				(proc0_3)
				(proc0_6)
				(gEgo view: 534 setLoop: 4 cel: 0 setCycle: End self)
			)
			(57
				(gGame changeScore: 50)
				(proc255_0 530 92 67 10 5 70 290)
				(= global66 803)
				((Inv at: 17) view: 31)
				(proc0_1 2)
			)
			(58
				(proc0_3)
				(gEgo posn: 141 129)
				(proc0_1 0)
				(aRope
					view: 530
					posn: 227 72
					cycleSpeed: 1
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(59
				(gGame setScript: (ScriptID 40))
				((ScriptID 40)
					caller: 27
					register: (Format @local4 530 93)
					next: (Format @local48 530 94)
				)
			)
			(60
				(proc0_6)
				(proc0_3)
				(= gGNumber_2 532)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 141 129 self
				)
			)
			(61
				(if (!= global66 803)
					(self cue:)
				else
					(proc255_0 530 95 67 -1 10)
					(gEgo
						view: 534
						setLoop: 5
						cel: 0
						cycleSpeed: 1
						setCycle: End self
					)
				)
			)
			(62
				(gEgo
					view: 534
					setLoop: 6
					cel: 0
					posn: 149 107
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(63
				(proc255_0 530 96)
				(gTheMusic fade:)
				(= seconds 3)
			)
			(64 (global2 newRoom: 535))
			(65
				(proc0_3)
				(proc255_0 (Format @local4 530 81 global170) 67 -1 10 88)
				(gTheMusic number: 4 loop: 1 play:)
				(gEgo
					view: 813
					setLoop: (if local1 1 else 0)
					illegalBits: 0
					ignoreActors:
					setPri: 5
					setStep: 1 8
					cel: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(66
				(gEgo setMotion: theJump)
				(theJump y: 300)
			)
			(67
				(proc0_5)
				(if (or (== gGNumber_2 534) (== gGNumber_2 535))
					(proc255_0 530 97)
				else
					(proc255_0 530 98)
				)
				(if global64
					(proc0_1)
					(= gGNumber_2 0)
					(if local1
						(gEgo posn: 210 77 setStep: 2 1)
					else
						(gEgo posn: 159 158)
					)
				else
					(gGame setScript: (ScriptID 40))
					((ScriptID 40)
						caller: 814
						register: (Format @local4 530 99)
					)
				)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'make,weave/blade,hemp')
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					(local1 (proc255_0 530 2))
					(else
						(switch local3
							(0 (proc255_0 530 3))
							(1 (self changeState: 44))
							(else  (proc255_0 530 4))
						)
					)
				)
			)
			((and (>= local3 4) (Said 'unfasten')) (proc255_0 530 5))
			(
			(or (Said 'hemp/boulder') (Said 'throw/blade,hemp'))
				(if (!= gGNumber_2 0)
					(proc0_9)
				else
					(switch local3
						(0 (proc255_0 530 6))
						(1
							(proc255_0 530 7)
							(gEgo put: 20 gNumber)
							(= local3 0)
						)
						(2
							(if (not (& (gEgo onControl:) $0004))
								(proc255_0 530 8)
							else
								(self changeState: 46)
							)
						)
						(3 (proc0_7))
						(4 (proc0_7))
						(531 (proc255_0 530 9))
					)
				)
			)
			((Said 'attach/hemp>')
				(cond 
					((Said '//coconut') (proc255_0 530 10))
					((!= gGNumber_2 531) (pEvent claimed: 1) (proc255_0 530 11))
					((Said '/[/!*]') (proc255_0 530 12))
					((Said '//palm')
						(switch local3
							(2 (proc255_0 530 11))
							(3 (self changeState: 53))
							(4 (proc0_7))
							(531 (proc255_0 530 13))
							(else  (proc255_0 530 14))
						)
					)
				)
			)
			(
				(or
					(Said 'make/belt,throw,belt,barstool,belt')
					(Said 'attach/hemp/i,self,entertainer')
					(Said 'use/dress')
					(Said 'break/skirt,cloth,dress')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((== global66 803) (proc255_0 530 15))
					((< local3 3) (proc255_0 530 16))
					((< local3 4) (proc255_0 530 17))
					((> local3 4) (proc255_0 530 18))
					(else (self changeState: 56))
				)
			)
			(
				(or
					(Said 'cross/canyon,hemp')
					(Said 'cross//canyon,hemp')
					(Said 'bang,go,grab,exit,use,climb/hemp,belt')
					(Said 'bang,go,grab,exit,use,climb//hemp,belt')
				)
				(cond 
					((!= gGNumber_2 0) (proc255_0 530 19))
					(local1 (proc255_0 530 20))
					((< local3 4) (proc255_0 530 21))
					((> 129 (gEgo y?)) (proc0_10))
					(else (self changeState: 60))
				)
			)
			((and local1 (Said '/hemp')) (proc255_0 530 22))
			((and local3 (Said 'test,look/hemp,knot')) (proc255_0 530 23))
			(
			(and (== local3 3) (Said 'use,climb,throw/hemp')) (proc255_0 530 24))
			((Said 'climb/palm')
				(cond 
					((== gGNumber_2 536) (self changeState: 42))
					((!= gGNumber_2 0) (proc0_9))
					(local1 (proc255_0 530 25))
					((& (gEgo onControl:) $0020) (proc255_0 530 26))
					((not (& (gEgo onControl:) $0010)) (proc255_0 530 27))
					(else (self changeState: 35))
				)
			)
			(
			(and (== gGNumber_2 536) (Said 'go,climb<down')) (self changeState: 42))
			((Said 'pick,get/coconut')
				(cond 
					((gEgo has: 19) (proc255_0 530 28))
					((!= gGNumber_2 536) (proc255_0 530 29))
					(else (self changeState: 37))
				)
			)
			((Said 'climb[<down]/boulder,canyon,ledge') (proc255_0 530 30) (proc255_0 530 31 67 -1 144))
			((Said 'climb<up[/boulder,canyon,ledge]') (proc255_0 530 32))
			(
			(or (Said 'look<down') (Said 'look/cliff,edge,canyon')) (proc255_0 530 33))
			(
				(and
					(not local1)
					(or
						(Said 'look/air,hose')
						(Said 'climb/cliff,cliff,cliff')
						(Said 'look<up')
					)
				)
				(proc255_0 530 34)
				(proc255_0 530 35)
			)
			((Said 'pick,get/blade,bush,bush,hemp')
				(if (!= gGNumber_2 0)
					(proc0_9)
				else
					(switch local3
						(0
							(if (not (& (gEgo onControl:) $0008))
								(proc0_10)
							else
								(self changeState: 7)
							)
						)
						(1 (proc255_0 530 36))
						(2 (proc255_0 530 37))
						(else  (proc255_0 530 38))
					)
				)
			)
			(
				(or
					(Said 'make,drag/blade')
					(Said 'burn,smoke/bush,bush,blade')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (gEgo has: 20)) (proc255_0 530 39))
					((> local3 1) (proc255_0 530 40))
					(else (= gGNumber_2 534) (self changeState: 15))
				)
			)
			(
				(or
					(Said 'backdrop/blade,bush/lip')
					(Said 'eat,eat/bush,bush,blade')
				)
				(cond 
					((!= gGNumber_2 0) (proc0_9))
					((not (gEgo has: 20)) (proc255_0 530 41))
					((> local3 1) (proc255_0 530 42))
					(else (= gGNumber_2 535) (self changeState: 15))
				)
			)
			((Said 'unfasten') (proc255_0 530 43))
			((Said 'drag,drag,drag/palm') (proc255_0 530 44))
			(
				(and
					(gEgo has: 19)
					(or
						(Said 'use,attach/coconut')
						(Said 'use,attach//coconut')
					)
				)
				(proc255_0 530 45)
			)
			((Said 'look>')
				(cond 
					((Said '/boulder')
						(cond 
							((== local3 531) (proc255_0 530 22))
							((== local3 4) (proc255_0 530 46) (proc255_0 530 47 67 -1 144))
							(else (proc255_0 530 48))
						)
					)
					((Said '/carpet') (proc255_0 530 49))
					((Said '/palm')
						(cond 
							(local1 (proc255_0 530 50))
							((== gGNumber_2 536) (proc255_0 530 51))
							(else (proc255_0 530 52))
						)
					)
					((Said '/coconut')
						(if (>= global88 2) (proc255_0 530 53 67 -1 144))
						(cond 
							((gEgo has: 19) (pEvent claimed: 0))
							(local1 (proc255_0 530 54))
							(else (proc255_0 530 55) (proc255_0 530 56))
						)
					)
					(
						(and
							(not (gEgo has: 20))
							(or (Said '/blade') (Said '/bush,exit'))
						)
						(if (== gGNumber_2 536)
							(proc255_0 530 57)
						else
							(proc255_0 530 58)
						)
					)
					((Said '/bush,exit')
						(cond 
							((== gGNumber_2 536) (proc255_0 530 57))
							(local1 (proc255_0 530 59))
							(else (proc255_0 530 60))
						)
					)
					((Said '[/ledge,area]')
						(cond 
							((== gGNumber_2 536) (proc255_0 530 61))
							(local1 (proc255_0 530 62))
							(else (proc255_0 530 63))
						)
					)
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
				)
				(if (== gCursorNumber 997) (pEvent claimed: 1))
				(if (== gCursorNumber 992) (pEvent claimed: 1))
				(if (== gGNumber_2 536)
					(pEvent claimed: 1)
					(if (== gCursorNumber 992)
						(pEvent claimed: 1)
						(= local71
							(proc255_0
								{&Qu+ quieres hacer ahora?}
								81
								{Bajar}
								1
								81
								{Coger Coco}
								2
							)
						)
						(switch local71
							(1
								(pEvent claimed: 1)
								(self changeState: 42)
								(pEvent claimed: 1)
							)
							(2
								(pEvent claimed: 1)
								(cond 
									((gEgo has: 19) (proc255_0 530 28))
									((!= gGNumber_2 536) (proc255_0 530 29))
									(else
										(pEvent claimed: 1)
										(self changeState: 37)
										(pEvent claimed: 1)
									)
								)
							)
						)
					)
				)
				(if (proc0_27 38 237 166 189 pEvent)
					(switch gCursorNumber
						(992 (pEvent claimed: 1))
						(998
							(pEvent claimed: 1)
							(proc255_0 {Ves plantas de marihuana})
						)
						(995
							(pEvent claimed: 1)
							(if (!= gGNumber_2 0)
								(proc0_9)
							else
								(switch local3
									(0
										(if (not (& (gEgo onControl:) $0008))
											(proc0_10)
										else
											(self changeState: 7)
										)
									)
									(1 (proc255_0 530 36))
									(2 (proc255_0 530 37))
									(else  (proc255_0 530 38))
								)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_26 gEgo (pEvent x?) (pEvent y?))
					(if (== gCursorNumber 20)
						(pEvent claimed: 1)
						(= temp0
							(proc255_0
								{&Qu+ quieres hacer?}
								81
								{Fumarla}
								1
								81
								{Una Cuerda}
								2
								81
								{Comerla}
								3
							)
						)
						(switch temp0
							(1
								(cond 
									((!= gGNumber_2 0) (proc0_9))
									((not (gEgo has: 20)) (proc255_0 530 39))
									((> local3 1) (proc255_0 530 40))
									(else (= gGNumber_2 534) (self changeState: 15))
								)
							)
							(2
								(cond 
									((!= gGNumber_2 0) (proc0_9))
									(local1 (proc255_0 530 2))
									(else
										(switch local3
											(0 (proc255_0 530 3))
											(1 (self changeState: 44))
											(else  (proc255_0 530 4))
										)
									)
								)
							)
							(3
								(cond 
									((!= gGNumber_2 0) (proc0_9))
									((not (gEgo has: 20)) (proc255_0 530 41))
									((> local3 1) (proc255_0 530 42))
									(else (= gGNumber_2 535) (self changeState: 15))
								)
							)
							(else  (pEvent claimed: 0))
						)
					)
					(if
						(or
							(== gCursorNumber 17)
							(== gCursorNumber 994)
							(== gCursorNumber 995)
						)
						(pEvent claimed: 1)
						(cond 
							((!= gGNumber_2 0) (proc0_9))
							((== global66 803) (proc255_0 530 15))
							((< local3 3) (proc255_0 530 16))
							((< local3 4) (proc255_0 530 17))
							((> local3 4) (proc255_0 530 18))
							(else (self changeState: 56))
						)
					)
				)
				(if
					(and
						(proc0_26 gEgo (pEvent x?) (pEvent y?))
						(== gCursorNumber 16)
					)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(16
							(cond 
								((proc0_23 16 484) (proc255_0 540 4))
								((proc0_23 16 -1) (proc0_12))
								((proc0_22 73) (proc255_0 540 7))
								((!= gGNumber_2 0) (proc0_9))
								(else ((ScriptID 540 1) changeState: 1))
							)
						)
					)
				)
				(if
				(and (proc0_27 135 250 69 117 pEvent) (== local3 4))
					(if (== gCursorNumber 992) (pEvent claimed: 1))
					(if (== gCursorNumber 995)
						(pEvent claimed: 1)
						(cond 
							((!= gGNumber_2 0) (proc255_0 530 19))
							(local1 (proc255_0 530 20))
							((< local3 4) (proc255_0 530 21))
							((> 129 (gEgo y?)) (proc0_10))
							(else (self changeState: 60))
						)
					)
				)
				(if (proc0_27 227 258 58 85 pEvent)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(992 (pEvent claimed: 1))
						(998 (proc255_0 530 48))
						(27
							(if (!= gGNumber_2 0)
								(proc0_9)
							else
								(switch local3
									(0 (proc255_0 530 6))
									(1
										(proc255_0 530 7)
										(gEgo put: 20 gNumber)
										(= local3 0)
									)
									(2
										(if (not (& (gEgo onControl:) $0004))
											(proc255_0 530 8)
										else
											(self changeState: 46)
										)
									)
									(3 (proc0_7))
									(4 (proc0_7))
									(531 (proc255_0 530 9))
								)
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_27 68 153 21 124 pEvent)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(992 (pEvent claimed: 1))
						(27
							(if (!= gGNumber_2 531)
								(pEvent claimed: 1)
								(proc255_0 530 11)
							else
								(switch local3
									(2 (proc255_0 530 11))
									(3 (self changeState: 53))
									(4 (proc0_7))
									(531 (proc255_0 530 13))
									(else  (proc255_0 530 14))
								)
							)
						)
						(995
							(cond 
								((== gGNumber_2 536) (self changeState: 42))
								((!= gGNumber_2 0) (proc0_9))
								(local1 (proc255_0 530 25))
								((& (gEgo onControl:) $0020) (proc255_0 530 26))
								((not (& (gEgo onControl:) $0010)) (proc255_0 530 26))
								(else (self changeState: 35))
							)
						)
						(998
							(cond 
								(local1 (proc255_0 530 50))
								((== gGNumber_2 536) (proc255_0 530 51))
								(else (proc255_0 530 52))
							)
						)
						(else  (pEvent claimed: 0))
					)
				)
				(if (proc0_27 1 319 21 62 pEvent)
					(pEvent claimed: 1)
					(switch gCursorNumber
						(992 (pEvent claimed: 1))
						(998
							(cond 
								((== gGNumber_2 536) (proc255_0 530 61))
								(local1 (proc255_0 530 62))
								(else (proc255_0 530 63))
							)
						)
					)
				)
			)
		)
	)
)

(instance aRope of Prop
	(properties
		y 1111
		x 999
		view 530
		loop 1
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: setPri: 7)
	)
)

(instance RopeScript of Script
	(properties)
	
	(method (cue)
		(aRope stopUpd:)
		(proc255_0 530 100 67 10 5 70 290)
	)
)

(instance atpTits of PV
	(properties
		y 157
		x 169
		view 532
		loop 3
		priority 7
		signal $4000
	)
)

(instance theJump of Jump
	(properties)
	
	(method (init)
		(super init: gEgo RoomScript)
		(self yStep: 2)
	)
)
