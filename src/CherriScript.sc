;;; Sierra Script 1.0 - (do not remove this comment)
(script# 422)
(include sci.sh)
(use Main)
(use n021)
(use Class_255_0)
(use Follow)
(use Cycle)
(use Obj)

(public
	CherriScript 0
)
(synonyms
	(babe babe dale cheri)
)

(instance CherriScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (and (== state 10) (> (gEgo x?) 280))
			(self cue:)
		)
		(if
			(and
				(== global104 2)
				(== (client loop?) 4)
				(== (client x?) 82)
				(== (client y?) 124)
			)
			(switch (Random 0 6)
				(0 (client setCel: 0))
				(1 (client setCycle: Fwd))
			)
		)
	)
	
	(method (changeState newState)
		(proc21_1 self newState 3 2)
		(switch (= state newState)
			(0
				(if (== global104 3) (self changeState: 3))
				(if (== global104 1)
					(self changeState: 10)
					(client posn: -20 143 stopUpd:)
				)
			)
			(1
				(proc0_6)
				(proc0_3)
				(= gGNumber_2 14)
				(proc255_4 422 5 global171)
				(client setStep: 0 0 setMotion: Follow gEgo 222)
				(= seconds 3)
			)
			(2
				(if (not (proc0_22 48))
					(proc0_19 48)
					(gGame changeScore: 5)
				)
				(proc255_0 422 6)
				(= gGEgoX (gEgo x?))
				(= gGEgoY (gEgo y?))
				(= gGEgoLoop (gEgo loop?))
				(global2 newRoom: 435)
			)
			(3 (proc0_3) (= seconds 3))
			(4
				(proc255_0 422 7)
				(= seconds 3)
			)
			(5
				(proc255_0 422 8)
				(client
					illegalBits: 0
					ignoreActors: 0
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 45 140 self
				)
				(if
					(and
						(> (gEgo y?) (client y?))
						(< (gEgo x?) (+ (client x?) 15))
					)
					(gEgo setCycle: Walk setMotion: MoveTo 97 (gEgo y?))
				)
			)
			(6 (gADoor setCycle: End self))
			(7
				(proc255_0 422 9)
				(gADoor stopUpd:)
				(client setMotion: MoveTo -20 140 self)
			)
			(8 (gADoor setCycle: Beg self))
			(9
				(gTheSoundFX number: 11 loop: 1 play:)
				(= global104 4)
				(gADoor stopUpd:)
				(proc0_1)
				(gEgo observeControl: 16384 8192)
				(client dispose:)
				(self dispose:)
			)
			(10 (= seconds 15))
			(11
				(if (< (gEgo x?) 160)
					(-- state)
					(= cycles 2)
				else
					(proc0_3)
					(gADoor setCycle: End self)
					(= seconds 0)
				)
			)
			(12
				(gADoor stopUpd:)
				(client
					posn: 13 140
					loop: 0
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 45 140 self
				)
			)
			(13 (gADoor setCycle: Beg self))
			(14
				(gTheSoundFX number: 11 loop: 1 play:)
				(gADoor stopUpd:)
				(client setMotion: MoveTo 82 124 self)
			)
			(15
				(client loop: 4)
				(= global104 2)
				(proc0_4)
				(gEgo observeControl: 16384 8192)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(!= (pEvent type?) evSAID)
				(!= global104 2)
				(pEvent claimed?)
			)
			(return)
		)
		(cond 
			((or (Said 'give/babe') (Said 'give/*/babe')) (proc255_0 422 0))
			((Said 'look/babe')
				(cond 
					((!= global104 2) (proc255_0 422 1))
					((!= gGNumber_2 0) (proc0_9))
					((!= (client xLast?) (client x?)) (proc255_0 422 2))
					((not (& (gEgo onControl:) $0020)) (proc255_0 422 3))
					(else (self changeState: 1))
				)
			)
			((and (== global104 2) (Said '/babe')) (proc255_0 422 4))
		)
	)
)
